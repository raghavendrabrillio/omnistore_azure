package com.brillio.omnistore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.omnistore.customerapp.service.ScheduleService;
import com.brillio.omnistore.customerapp.service.impl.RandomSlotUtil;
import com.brillio.omnistore.dto.ScheduleDto;
import com.brillio.omnistore.dto.ScheduleSlotsDto;
import com.brillio.omnistore.payload.request.NotifyAssociateRequest;
import com.brillio.omnistore.payload.request.ScheduleRequest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/omnistore/returns")
@SecurityRequirement(name = "omnistore")
@Tag(name = "Returns Endpoints")
public class ReturnsController {

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/schedules/{userId}")
	public ResponseEntity<List<ScheduleDto>> getSchedules(@PathVariable(value = "userId") String userId,
			@RequestParam(name = "status") Optional<String> status) {
		return new ResponseEntity<>(scheduleService.getSchedules(userId, status.orElseGet(() -> "")), HttpStatus.OK);
	}

	@GetMapping("/schedule/{id}")
	public ResponseEntity<ScheduleDto> getSchedulesById(@PathVariable(value = "id") String id) {
		return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
	}

	@PostMapping("/schedules")
	public ScheduleDto createSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest) {
		return scheduleService.createSchedule(scheduleRequest);
	}

	@PutMapping("/schedules/{scheduleId}")
	public ScheduleDto updateSchedule(@PathVariable(value = "scheduleId") String scheduleId,
			@Valid @RequestBody ScheduleRequest scheduleRequest) {
		return scheduleService.updateSchedule(scheduleId, scheduleRequest);
	}

	@DeleteMapping("/schedules/{scheduleId}")
	public String deleteSchedule(@PathVariable(value = "scheduleId") String scheduleId) {
		boolean isDeleteSucccess = scheduleService.deleteSchedule(scheduleId);
		if (isDeleteSucccess)
			return "Successfully deleted Schedule";

		return "Error in deleting Schedule with Id: " + scheduleId;
	}

	@PostMapping("/notify/associate")
	public String notifyAssociate(@Valid @RequestBody NotifyAssociateRequest notifyAssociateRequest) {
		scheduleService.notifyAssociate(notifyAssociateRequest);
		return "Notified successfully";
	}

	@PostMapping("/notify/customer/{userId}")
	public String notifyCustomer(@RequestBody String payload, @PathVariable(value = "userId") String userId) {
		scheduleService.notifyCustomer(payload, userId);
		return "Notified successfully";
	}

	@GetMapping("/schedule/slots")
	public ResponseEntity<List<ScheduleSlotsDto>> getAvailableSlots() {
		return new ResponseEntity<>(
				scheduleService.getAvailableSlots(RandomSlotUtil.START_HOUR, RandomSlotUtil.END_HOUR), HttpStatus.OK);
	}

}
