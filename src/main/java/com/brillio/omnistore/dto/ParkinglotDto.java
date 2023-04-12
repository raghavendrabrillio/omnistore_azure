package com.brillio.omnistore.dto;

import java.sql.Timestamp;

public class ParkinglotDto implements DataTransferObject {
	private static final long serialVersionUID = 1L;

	private String id;

	private Timestamp createdDate;

	private String parkingLotNum;

	private String status;

	private String updatedBy;

	private Timestamp updatedDate;

	public ParkinglotDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getParkingLotNum() {
		return this.parkingLotNum;
	}

	public void setParkingLotNum(String parkingLotNum) {
		this.parkingLotNum = parkingLotNum;
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