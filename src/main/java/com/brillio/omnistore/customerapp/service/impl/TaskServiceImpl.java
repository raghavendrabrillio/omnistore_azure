package com.brillio.omnistore.customerapp.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.omnistore.customerapp.repository.ScheduleRepository;
import com.brillio.omnistore.customerapp.repository.TaskRepository;
import com.brillio.omnistore.customerapp.service.OrderService;
import com.brillio.omnistore.customerapp.service.TaskService;
import com.brillio.omnistore.dto.OrderitemDto;
import com.brillio.omnistore.dto.ParkinglotDto;
import com.brillio.omnistore.dto.ScheduleDto;
import com.brillio.omnistore.dto.SchedulestatusDto;
import com.brillio.omnistore.dto.TaskDto;
import com.brillio.omnistore.model.Parkinglot;
import com.brillio.omnistore.model.Schedule;
import com.brillio.omnistore.model.Schedulestatus;
import com.brillio.omnistore.model.Task;
import com.brillio.omnistore.payload.request.TaskRequest;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private OrderService orderService;

	@Override
	public List<TaskDto> getTasks(String status, String userId) {
		List<Task> tasks = null;
		if (null != status && !status.isBlank()) {
			tasks = taskRepository.findByStatusAndAssignedToOrderByUpdatedDateDesc(status, userId);
		} else {
			tasks = taskRepository.findByAssignedToOrderByUpdatedDateDesc(userId);
		}
		List<TaskDto> taskDtos = new ArrayList<>();
		for (Task task : tasks) {
			TaskDto taskDto = mapTaskDto(task);
			taskDtos.add(taskDto);
		}
		return taskDtos;
	}

	private TaskDto mapTaskDto(Task task) {
		TaskDto taskDto = new TaskDto();
		taskDto.setId(task.getId());
		taskDto.setAssignedTo(task.getAssignedTo());
		taskDto.setCreatedTime(task.getCreatedTime());
		taskDto.setStatus(task.getStatus());
		taskDto.setUpdatedBy(task.getUpdatedBy());
		taskDto.setUpdatedDate(task.getUpdatedDate());
		Schedule schedule = task.getSchedule();
		ScheduleDto scheduleDto = new ScheduleDto();
		scheduleDto.setId(schedule.getId());
		scheduleDto.setOrderitemId(schedule.getOrderitemId());
		scheduleDto.setScheduledTime(schedule.getScheduledTime());
		scheduleDto.setStatus(schedule.getStatus());
		scheduleDto.setUpdatedBy(schedule.getUpdatedBy());
		scheduleDto.setUpdatedDate(schedule.getUpdatedDate());
		scheduleDto.setUserId(schedule.getUserId());
		scheduleDto.setScheduleType(schedule.getScheduleType());
		scheduleDto.setExchangeOrderitemId(schedule.getExchangeOrderitemId());
		mapOrderItem(schedule, scheduleDto);
		mapExchangeOrderItem(schedule, scheduleDto);
		mapSchedulestatus(schedule, scheduleDto);
		Parkinglot parkinglot = schedule.getParkinglot();
		if (null == parkinglot) {
			Optional<Schedule> scheduleForParkingLot = scheduleRepository.findById(schedule.getId());
			if (scheduleForParkingLot.isPresent()) {
				parkinglot = scheduleForParkingLot.get().getParkinglot();
			}

		}
		if (null != parkinglot) {
			ParkinglotDto parkinglotDto = new ParkinglotDto();
			parkinglotDto.setId(parkinglot.getId());
			parkinglotDto.setCreatedDate(parkinglot.getCreatedDate());
			parkinglotDto.setParkingLotNum(parkinglot.getParkingLotNum());
			parkinglotDto.setStatus(parkinglot.getStatus());
			parkinglotDto.setUpdatedBy(parkinglot.getUpdatedBy());
			parkinglotDto.setUpdatedDate(parkinglot.getUpdatedDate());
			scheduleDto.setParkinglot(parkinglotDto);
		}
		taskDto.setScheduleDto(scheduleDto);
		return taskDto;
	}

	private void mapExchangeOrderItem(Schedule schedule, ScheduleDto scheduleDto) {
		if (null != schedule.getExchangeOrderitemId()) {
			OrderitemDto orderitemDto = orderService.getOrderItemById(schedule.getExchangeOrderitemId());
			scheduleDto.setExchangeOrderitem(orderitemDto);
		}
	}

	private void mapOrderItem(Schedule schedule, ScheduleDto scheduleDto) {

		OrderitemDto orderitemDto = orderService.getOrderItemById(schedule.getOrderitemId());
		scheduleDto.setOrderitem(orderitemDto);
	}

	private void mapSchedulestatus(Schedule schedule, ScheduleDto scheduleDto) {
		List<SchedulestatusDto> schedulestatusDtos = new ArrayList<>();
		List<Schedulestatus> schedulestatuses = schedule.getSchedulestatuses();
		for (Schedulestatus schedulestatus : schedulestatuses) {
			SchedulestatusDto schedulestatusDto = new SchedulestatusDto();
			schedulestatusDto.setId(schedulestatus.getId());
			schedulestatusDto.setStatus(schedulestatus.getStatus());
			schedulestatusDto.setUpdatedBy(schedulestatus.getUpdatedBy());
			schedulestatusDto.setUpdatedDate(schedulestatus.getUpdatedDate());
			schedulestatusDtos.add(schedulestatusDto);
		}
		scheduleDto.setSchedulestatus(schedulestatusDtos);

	}

	@Override
	public TaskDto createTask(TaskRequest taskRequest) {
		Task task = new Task();
		task.setAssignedTo(taskRequest.getAssignedTo());
		task.setCreatedTime(new Timestamp(new Date().getTime()));
		task.setStatus("Active");
		task.setUpdatedBy(taskRequest.getUserId());
		task.setUpdatedDate(new Timestamp(new Date().getTime()));

		Optional<Schedule> schedule = scheduleRepository.findById(taskRequest.getScheduleId());
		if (schedule.isPresent()) {
			task.setSchedule(schedule.get());
		}
		return saveTaskAndReturnTaskDto(task);
	}

	private TaskDto saveTaskAndReturnTaskDto(Task task) {
		Task taskSaved = taskRepository.save(task);
		return mapTaskDto(taskSaved);
	}

	@Override
	public TaskDto updateTask(String taskId, TaskRequest taskRequest) {
		Optional<Task> taskFromDb = taskRepository.findById(taskId);
		if (taskFromDb.isPresent()) {
			Task task = taskFromDb.get();
			task.setAssignedTo(taskRequest.getAssignedTo());
			task.setStatus(taskRequest.getStatus());
			task.setUpdatedBy(taskRequest.getUserId());
			task.setUpdatedDate(new Timestamp(new Date().getTime()));
//			if (taskRequest.getScheduleNotes() != null && !taskRequest.getScheduleNotes().isEmpty()) {
//				Optional<Schedule> scheduleFromDb = scheduleRepository.findById(taskRequest.getScheduleId());
//				if (scheduleFromDb.isPresent()) {
//					Schedule schedule = scheduleFromDb.get();
//					Schedulestatus schedulestatus = new Schedulestatus();
//					schedulestatus.setSchedule(schedule);
//					schedulestatus.setStatus(taskRequest.getScheduleNotes());
//					schedulestatus.setUpdatedBy(taskRequest.getUserId());
//					schedulestatus.setUpdatedDate(new Timestamp(new Date().getTime()));
//					schedule.addSchedulestatus(schedulestatus);
//					scheduleRepository.save(schedule);
//				}
//			}
			return saveTaskAndReturnTaskDto(task);
		}
		return null;
	}

	@Override
	public boolean deleteTask(String taskId) {
		Optional<Task> taskFromDb = taskRepository.findById(taskId);
		if (taskFromDb.isPresent()) {
			taskRepository.delete(taskFromDb.get());
			return true;
		}
		return false;
	}

}
