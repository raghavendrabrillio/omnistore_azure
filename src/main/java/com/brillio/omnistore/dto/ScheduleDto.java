package com.brillio.omnistore.dto;

import java.sql.Timestamp;
import java.util.List;

public class ScheduleDto implements DataTransferObject {
	private static final long serialVersionUID = 1L;

	private String id;

	private String orderitemId;

	private Timestamp scheduledTime;

	private String status;

	private String updatedBy;

	private Timestamp updatedDate;

	private String userId;

	private ParkinglotDto parkinglot;

	private List<SchedulestatusDto> schedulenotes;

	private OrderitemDto orderitem;

	private OrderitemDto exchangeOrderitem;

	private String scheduleType;

	private String exchangeOrderitemId;

	public ScheduleDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderitemId() {
		return this.orderitemId;
	}

	public void setOrderitemId(String orderitemId) {
		this.orderitemId = orderitemId;
	}

	public Timestamp getScheduledTime() {
		return this.scheduledTime;
	}

	public void setScheduledTime(Timestamp scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ParkinglotDto getParkinglot() {
		return parkinglot;
	}

	public void setParkinglot(ParkinglotDto parkinglot) {
		this.parkinglot = parkinglot;
	}

	public List<SchedulestatusDto> getSchedulestatus() {
		return schedulenotes;
	}

	public void setSchedulestatus(List<SchedulestatusDto> schedulestatus) {
		this.schedulenotes = schedulestatus;
	}

	public OrderitemDto getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(OrderitemDto orderitem) {
		this.orderitem = orderitem;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getExchangeOrderitemId() {
		return exchangeOrderitemId;
	}

	public void setExchangeOrderitemId(String exchangeOrderitemId) {
		this.exchangeOrderitemId = exchangeOrderitemId;
	}

	public OrderitemDto getExchangeOrderitem() {
		return exchangeOrderitem;
	}

	public void setExchangeOrderitem(OrderitemDto exchangeOrderitem) {
		this.exchangeOrderitem = exchangeOrderitem;
	}

}