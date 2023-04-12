package com.brillio.omnistore.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@Table(name = "schedule", schema = "omnistore")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "orderitem_id")
	private String orderitemId;

	@Column(name = "exchange_orderitem_id")
	private String exchangeOrderitemId;

	@Column(name = "scheduled_time")
	private Timestamp scheduledTime;

	private String status;

	@Column(name = "schedule_type")
	private String scheduleType;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "user_id")
	private String userId;

	// bi-directional many-to-one association to Parkinglot
	@ManyToOne
	@JoinColumn(name = "parking_lot_id")
	private Parkinglot parkinglot;

	// bi-directional many-to-one association to Task
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task> tasks = new ArrayList<>();

	// bi-directional many-to-one association to schedule status
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "updatedDate desc")
	private List<Schedulestatus> schedulestatuses = new ArrayList<>();

	public Schedule() {
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

	public Parkinglot getParkinglot() {
		return this.parkinglot;
	}

	public void setParkinglot(Parkinglot parkinglot) {
		this.parkinglot = parkinglot;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setSchedule(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setSchedule(null);

		return task;
	}

	public List<Schedulestatus> getSchedulestatuses() {
		return schedulestatuses;
	}

	public void setSchedulestatuses(List<Schedulestatus> schedulestatuses) {
		this.schedulestatuses = schedulestatuses;
	}

	public Schedulestatus addSchedulestatus(Schedulestatus schedulestatus) {
		getSchedulestatuses().add(schedulestatus);
		schedulestatus.setSchedule(this);

		return schedulestatus;
	}

	public Schedulestatus removeSchedulestatus(Schedulestatus schedulestatus) {
		getSchedulestatuses().remove(schedulestatus);
		schedulestatus.setSchedule(null);
		return schedulestatus;
	}

	public String getExchangeOrderitemId() {
		return exchangeOrderitemId;
	}

	public void setExchangeOrderitemId(String exchangeOrderitemId) {
		this.exchangeOrderitemId = exchangeOrderitemId;
	}

}