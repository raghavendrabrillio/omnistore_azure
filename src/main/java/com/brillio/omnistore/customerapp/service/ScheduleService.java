package com.brillio.omnistore.customerapp.service;

import java.util.List;

import com.brillio.omnistore.dto.ScheduleDto;
import com.brillio.omnistore.dto.ScheduleSlotsDto;
import com.brillio.omnistore.payload.request.NotifyAssociateRequest;
import com.brillio.omnistore.payload.request.ScheduleRequest;

public interface ScheduleService {

	List<ScheduleDto> getSchedules(String userId, String status);

	ScheduleDto createSchedule(ScheduleRequest scheduleRequest);

	ScheduleDto updateSchedule(String scheduleId, ScheduleRequest scheduleRequest);

	boolean deleteSchedule(String scheduleId);
	
	void notifyAssociate(NotifyAssociateRequest notifyAssociateRequest);

	ScheduleDto getScheduleById(String id);
	
	List<ScheduleSlotsDto> getAvailableSlots(int startHour, int endHour);

	void notifyCustomer(String payload, String userId);
}
