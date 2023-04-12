package com.brillio.omnistore.dto;

import java.sql.Timestamp;
import java.util.List;

public class PurchaseOrderDto implements DataTransferObject {
	private static final long serialVersionUID = 1L;

	private String id;

	private String createdBy;

	private Timestamp creationDate;

	private String notes;

	private String orderType;

	private String updatedBy;

	private Timestamp updatedDate;

	private String userId;

	private List<InvoiceDto> invoiceDtos;

	private List<OrderitemDto> orderitemDtos;

	public PurchaseOrderDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public List<InvoiceDto> getInvoices() {
		return this.invoiceDtos;
	}

	public void setInvoices(List<InvoiceDto> invoiceDtos) {
		this.invoiceDtos = invoiceDtos;
	}

	public List<OrderitemDto> getOrderitems() {
		return this.orderitemDtos;
	}

	public void setOrderitems(List<OrderitemDto> orderitemDtos) {
		this.orderitemDtos = orderitemDtos;
	}

}