package com.brillio.omnistore.dto;

import java.sql.Timestamp;

public class OrderitemDto implements DataTransferObject {
	private static final long serialVersionUID = 1L;

	private String id;

	private double amount;

	private Timestamp createdDate;

	private String originalLineItemId;

	private double quantity;

	private String status;

	private String qrCode;

	private String updatedBy;

	private Timestamp updatedDate;

	private ProductDto productDto;

	private InvoiceitemDto invoiceitemDto;

	public OrderitemDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getOriginalLineItemId() {
		return this.originalLineItemId;
	}

	public void setOriginalLineItemId(String originalLineItemId) {
		this.originalLineItemId = originalLineItemId;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
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

	public ProductDto getProduct() {
		return this.productDto;
	}

	public void setProduct(ProductDto productDto) {
		this.productDto = productDto;
	}

	public InvoiceitemDto getInvoiceitem() {
		return invoiceitemDto;
	}

	public void setInvoiceitem(InvoiceitemDto invoiceitemDto) {
		this.invoiceitemDto = invoiceitemDto;
	}

	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}