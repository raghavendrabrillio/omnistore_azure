package com.brillio.omnistore.customerapp.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.omnistore.customerapp.repository.ParkingLotRepository;
import com.brillio.omnistore.customerapp.repository.ScheduleRepository;
import com.brillio.omnistore.customerapp.service.OrderService;
import com.brillio.omnistore.customerapp.service.ScheduleService;
import com.brillio.omnistore.dto.OrderitemDto;
import com.brillio.omnistore.dto.ParkinglotDto;
import com.brillio.omnistore.dto.ScheduleDto;
import com.brillio.omnistore.dto.ScheduleSlotsDto;
import com.brillio.omnistore.dto.SchedulestatusDto;
import com.brillio.omnistore.dto.UserDto;
import com.brillio.omnistore.model.Parkinglot;
import com.brillio.omnistore.model.Schedule;
import com.brillio.omnistore.model.Schedulestatus;
import com.brillio.omnistore.model.Task;
import com.brillio.omnistore.model.User;
import com.brillio.omnistore.notification.Message;
import com.brillio.omnistore.notification.service.NotificationService;
import com.brillio.omnistore.payload.request.NotifyAssociateRequest;
import com.brillio.omnistore.payload.request.ScheduleRequest;
import com.brillio.omnistore.user.service.UserService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

//	private static final String STATUS_UN_ASSIGNED = "UnAssigned";

	private static final String STATUS_ACTIVE = "Active";

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private ParkingLotRepository parkingLotRepository;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Override
	public List<ScheduleDto> getSchedules(String userId, String status) {
		List<Schedule> schedules = scheduleRepository.findByUserIdOrderByStatusAscUpdatedDateDesc(userId);
		List<ScheduleDto> scheduleDtos = new ArrayList<>();
		for (Schedule schedule : schedules) {
			ScheduleDto scheduleDto = mapScheduleDto(schedule);
			scheduleDtos.add(scheduleDto);
		}
		return scheduleDtos;
	}

	private ScheduleDto mapScheduleDto(Schedule schedule) {
		ScheduleDto scheduleDto = mapSchedule(schedule);
		mapParkingLot(schedule, scheduleDto);
		mapSchedulestatus(schedule, scheduleDto);
		mapOrderItem(schedule, scheduleDto);
		mapExchangeOrderItem(schedule, scheduleDto);
		return scheduleDto;
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

	private void mapParkingLot(Schedule schedule, ScheduleDto scheduleDto) {
		Parkinglot parkinglot = schedule.getParkinglot();
		if (parkinglot != null) {
			ParkinglotDto parkinglotDto = new ParkinglotDto();
			parkinglotDto.setId(parkinglot.getId());
			parkinglotDto.setCreatedDate(parkinglot.getCreatedDate());
			parkinglotDto.setParkingLotNum(parkinglot.getParkingLotNum());
			parkinglotDto.setStatus(parkinglot.getStatus());
			parkinglotDto.setUpdatedBy(parkinglot.getUpdatedBy());
			parkinglotDto.setUpdatedDate(parkinglot.getUpdatedDate());
			scheduleDto.setParkinglot(parkinglotDto);
		}
	}

	private ScheduleDto mapSchedule(Schedule schedule) {
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
		return scheduleDto;
	}

	@Override
	public ScheduleDto createSchedule(ScheduleRequest scheduleRequest) {
		Schedule schedule = new Schedule();
		schedule.setOrderitemId(scheduleRequest.getOrderitemId());
		schedule.setStatus(STATUS_ACTIVE);
		schedule.setUserId(scheduleRequest.getUserId());
		schedule.setScheduleType(scheduleRequest.getType());
		schedule.setExchangeOrderitemId(scheduleRequest.getExchangeOrderitemId());
		Parkinglot parkinglot = new Parkinglot();
		String alphabet = "ABCDE";
		Random r = new Random();
		String prefix = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
		int result = r.nextInt(5 - 1) + 1;
		String suffix = String.valueOf(result);
		String parkingLotNum = prefix + "-" + suffix;
		List<Parkinglot> parkinglots = parkingLotRepository.findByParkingLotNum(parkingLotNum);
		if (!parkinglots.isEmpty()) {
			parkinglot = parkinglots.get(0);
		} else {
			parkinglot.setCreatedDate(new Timestamp(new Date().getTime()));
			parkinglot.setParkingLotNum(parkingLotNum);
			parkinglot.setStatus(STATUS_ACTIVE);
			parkinglot.setUpdatedBy(scheduleRequest.getUserId());
			parkinglot.setUpdatedDate(new Timestamp(new Date().getTime()));
			parkinglot = parkingLotRepository.save(parkinglot);
		}
		schedule.setParkinglot(parkinglot);
		Task task = new Task();
		List<User> users = userService.getUsersByTypes(Arrays.asList("Associate"));
		if (null != users && !users.isEmpty()) {
			task.setAssignedTo(users.get(0).getId());
		} else {
			task.setAssignedTo(scheduleRequest.getUserId());
		} // TODO-raghu auto assign to associate
		task.setCreatedTime(scheduleRequest.getSlotTime());
		task.setStatus(STATUS_ACTIVE);
		task.setUpdatedBy(scheduleRequest.getUserId());
		task.setUpdatedDate(new Timestamp(new Date().getTime()));
		task.setSchedule(schedule);
		Schedulestatus schedulestatus = new Schedulestatus();
		schedulestatus.setSchedule(schedule);
		schedulestatus.setStatus("Task Assigned");
		schedulestatus.setUpdatedBy(scheduleRequest.getUserId());
		schedulestatus.setUpdatedDate(new Timestamp(new Date().getTime()));
		schedule.addSchedulestatus(schedulestatus);
		schedule.addTask(task);
		schedule.setScheduledTime(scheduleRequest.getSlotTime());
		schedule.setUpdatedBy(scheduleRequest.getUserId());
		schedule.setUpdatedDate(new Timestamp(new Date().getTime()));
		return saveScheduleAndReturnScheduleDto(schedule);
	}

	private ScheduleDto saveScheduleAndReturnScheduleDto(Schedule schedule) {
		Schedule scheduleSaved = scheduleRepository.save(schedule);
		return mapScheduleDto(scheduleSaved);
	}

	@Override
	public ScheduleDto updateSchedule(String scheduleId, ScheduleRequest scheduleRequest) {
		Optional<Schedule> scheduleFromDb = scheduleRepository.findById(scheduleId);
		if (scheduleFromDb.isPresent()) {
			Schedule schedule = scheduleFromDb.get();
			schedule.setOrderitemId(scheduleRequest.getOrderitemId());
			schedule.setStatus(scheduleRequest.getStatus());
			schedule.setUserId(scheduleRequest.getUserId());
			schedule.setUpdatedBy(scheduleRequest.getUserId());
			schedule.setScheduleType(scheduleRequest.getType());
			schedule.setExchangeOrderitemId(scheduleRequest.getExchangeOrderitemId());
			schedule.setUpdatedDate(new Timestamp(new Date().getTime()));
			Schedulestatus schedulestatus = new Schedulestatus();
			schedulestatus.setSchedule(schedule);
			schedulestatus.setStatus(scheduleRequest.getScheduleNotes());
			schedulestatus.setUpdatedBy(scheduleRequest.getUserId());
			schedulestatus.setUpdatedDate(new Timestamp(new Date().getTime()));
			schedule.addSchedulestatus(schedulestatus);
			return saveScheduleAndReturnScheduleDto(schedule);
		}
		return null;
	}

	@Override
	public boolean deleteSchedule(String scheduleId) {
		Optional<Schedule> scheduleFromDb = scheduleRepository.findById(scheduleId);
		if (scheduleFromDb.isPresent()) {
			scheduleRepository.delete(scheduleFromDb.get());
			return true;
		}
		return false;
	}

	@Override
	public void notifyAssociate(NotifyAssociateRequest notifyAssociateRequest) {
		Optional<Schedule> scheduleFromDb = scheduleRepository.findById(notifyAssociateRequest.getScheduleId());
		if (scheduleFromDb.isPresent()) {
			Schedule schedule = scheduleFromDb.get();
			Schedulestatus schedulestatus = new Schedulestatus();
			schedulestatus.setSchedule(schedule);
			schedulestatus.setStatus(notifyAssociateRequest.getMessage());
			schedulestatus.setUpdatedBy(schedule.getUserId());
			schedulestatus.setUpdatedDate(new Timestamp(new Date().getTime()));
			schedule.addSchedulestatus(schedulestatus);
			saveScheduleAndReturnScheduleDto(schedule);
			List<Task> tasks = schedule.getTasks();
			Set<String> usersToNotify = new HashSet<>();
			boolean isTaskUnAssigned = false;
			String taskId = "";
			for (Task task : tasks) {
				String assignedTo = task.getAssignedTo();
				if (null != assignedTo && !assignedTo.isEmpty()) {
					usersToNotify.add(assignedTo);
					taskId = task.getId();
					continue;
				} else {
					isTaskUnAssigned = true;
				}
			}
			if (isTaskUnAssigned) {
				List<User> users = userService.getUsersByTypes(Arrays.asList("Admin", "Associate"));
				usersToNotify.addAll(users.stream().map(m -> m.getId()).toList());
			}
			UserDto userDto = userService.getCustomerProfile(schedule.getUserId());
			String userName = "";
			if (null != userDto) {
				userName = userDto.getFirstName() + " " + userDto.getLastName();
				userName = userName.trim();
			}
			for (String user : usersToNotify) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("taskId", taskId);
				jsonObject.put("message", notifyAssociateRequest.getMessage());
				jsonObject.put("scheduleId", schedule.getId());
				jsonObject.put("user", userName);
				Message message = new Message(jsonObject.toString());
				notificationService.notify(message, user);
			}
		}

	}

	@Override
	public ScheduleDto getScheduleById(String id) {
		ScheduleDto scheduleDto = new ScheduleDto();
		Optional<Schedule> schedules = scheduleRepository.findById(id);
		if (schedules.isPresent()) {
			scheduleDto = mapScheduleDto(schedules.get());
		}
		return scheduleDto;
	}

	@Override
	public List<ScheduleSlotsDto> getAvailableSlots(int startHour, int endHour) {
		Map<Timestamp, Boolean> slots = RandomSlotUtil.getSlots(startHour, endHour);
		List<ScheduleSlotsDto> scheduleSlotsDtos = new ArrayList<>();
		slots.forEach((k, v) -> {
			ScheduleSlotsDto scheduleSlotsDto = new ScheduleSlotsDto();
			scheduleSlotsDto.setAvailable(v);
			scheduleSlotsDto.setSlot(k);
			scheduleSlotsDtos.add(scheduleSlotsDto);
		});
		return scheduleSlotsDtos;
	}

	@Override
	public void notifyCustomer(String payload, String userId) {
		Message message = new Message(payload);
		notificationService.notifyCustomer(message, userId);
	}

}
