package com.brillio.omnistore.payload.request;

import javax.validation.constraints.NotBlank;

public class NotifyAssociateRequest {

	@NotBlank
	private String scheduleId;

	@NotBlank
	private String message;

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
