package com.brillio.omnistore.dto;

import java.sql.Timestamp;

public class ScheduleSlotsDto implements DataTransferObject {

	private static final long serialVersionUID = 3617255842815621197L;

	private boolean available;
	private Timestamp slot;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Timestamp getSlot() {
		return slot;
	}

	public void setSlot(Timestamp slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return "ScheduleSlotsDto [available=" + available + ", slot=" + slot + "]";
	}

}
