package com.brillio.omnistore.payload.request;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

public class ScheduleRequest {

	@NotBlank
	private String orderitemId;

	private String status;

	@NotBlank
	private String type;

	@NotBlank
	private String userId;

	private String exchangeOrderitemId;

	private String scheduleNotes;

	private Timestamp slotTime;

	public Timestamp getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(Timestamp slotTime) {
		this.slotTime = slotTime;
	}

	public String getScheduleNotes() {
		return scheduleNotes;
	}

	public void setScheduleNotes(String scheduleNotes) {
		this.scheduleNotes = scheduleNotes;
	}

	public String getOrderitemId() {
		return orderitemId;
	}

	public void setOrderitemId(String orderitemId) {
		this.orderitemId = orderitemId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExchangeOrderitemId() {
		return exchangeOrderitemId;
	}

	public void setExchangeOrderitemId(String exchangeOrderitemId) {
		this.exchangeOrderitemId = exchangeOrderitemId;
	}

}
