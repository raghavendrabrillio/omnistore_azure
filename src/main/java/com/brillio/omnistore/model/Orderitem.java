package com.brillio.omnistore.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * The persistent class for the orderitem database table.
 * 
 */
@Entity
@Table(name = "orderitem", schema = "omnistore")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private double amount;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "original_line_item_id")
	private String originalLineItemId;

	private double quantity;

	private String status;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "qr_code")
	private String qrCode;

	// bi-directional many-to-one association to Invoiceitem
	@OneToMany(mappedBy = "orderitem")
	private List<Invoiceitem> invoiceitems;

	// bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name = "order_id")
	private PurchaseOrder purchaseorder;

	// bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public Orderitem() {
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

	public List<Invoiceitem> getInvoiceitems() {
		return this.invoiceitems;
	}

	public void setInvoiceitems(List<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Invoiceitem addInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().add(invoiceitem);
		invoiceitem.setOrderitem(this);

		return invoiceitem;
	}

	public Invoiceitem removeInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().remove(invoiceitem);
		invoiceitem.setOrderitem(null);

		return invoiceitem;
	}

	public PurchaseOrder getPurchaseorder() {
		return this.purchaseorder;
	}

	public void setPurchaseorder(PurchaseOrder purchaseorder) {
		this.purchaseorder = purchaseorder;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@PrePersist
	public void initializeUUID() {
		if (id == null) {
			id = UUID.randomUUID().toString().substring(0, 20);
		} else {
			id = id.toString().substring(0, 20);
		}
	}

}