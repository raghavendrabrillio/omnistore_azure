package com.brillio.omnistore.payload.request;

import javax.validation.constraints.NotBlank;

public class TaskRequest {

	private String status;

	@NotBlank
	private String scheduleId;

	@NotBlank
	private String userId;

	@NotBlank
	private String assignedTo;

//	private String scheduleNotes;

//	public String getScheduleNotes() {
//		return scheduleNotes;
//	}
//
//	public void setScheduleNotes(String scheduleNotes) {
//		this.scheduleNotes = scheduleNotes;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

}
