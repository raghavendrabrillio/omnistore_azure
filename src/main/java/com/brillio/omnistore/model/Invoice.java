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
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table(name = "invoice", schema = "omnistore")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	// bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name = "order_id")
	private PurchaseOrder purchaseorder;

	// bi-directional many-to-one association to Invoiceitem
	@OneToMany(mappedBy = "invoice")
	private List<Invoiceitem> invoiceitems;

	public Invoice() {
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

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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

	public PurchaseOrder getPurchaseorder() {
		return this.purchaseorder;
	}

	public void setPurchaseorder(PurchaseOrder purchaseorder) {
		this.purchaseorder = purchaseorder;
	}

	public List<Invoiceitem> getInvoiceitems() {
		return this.invoiceitems;
	}

	public void setInvoiceitems(List<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Invoiceitem addInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().add(invoiceitem);
		invoiceitem.setInvoice(this);

		return invoiceitem;
	}

	public Invoiceitem removeInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().remove(invoiceitem);
		invoiceitem.setInvoice(null);

		return invoiceitem;
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