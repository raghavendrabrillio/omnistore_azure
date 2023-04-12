package com.brillio.omnistore.dto;

import java.sql.Timestamp;

public class SchedulestatusDto implements DataTransferObject {
	private static final long serialVersionUID = 1L;

	private String id;

	private String status;

	private String updatedBy;

	private Timestamp updatedDate;

	public SchedulestatusDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

}