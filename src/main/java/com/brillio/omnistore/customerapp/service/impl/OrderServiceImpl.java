package com.brillio.omnistore.customerapp.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.omnistore.customerapp.repository.InvoiceRepository;
import com.brillio.omnistore.customerapp.repository.InvoiceitemRepository;
import com.brillio.omnistore.customerapp.repository.OrderRepository;
import com.brillio.omnistore.customerapp.repository.OrderitemRepository;
import com.brillio.omnistore.customerapp.repository.ProductRepository;
import com.brillio.omnistore.customerapp.service.OrderService;
import com.brillio.omnistore.dto.InvoiceDto;
import com.brillio.omnistore.dto.InvoiceitemDto;
import com.brillio.omnistore.dto.OrderitemDto;
import com.brillio.omnistore.dto.ProductDto;
import com.brillio.omnistore.dto.PurchaseOrderDto;
import com.brillio.omnistore.model.Invoice;
import com.brillio.omnistore.model.Invoiceitem;
import com.brillio.omnistore.model.Orderitem;
import com.brillio.omnistore.model.Product;
import com.brillio.omnistore.model.PurchaseOrder;
import com.brillio.omnistore.payload.request.OrderitemRequest;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderitemRepository orderitemRepository;

	@Autowired
	private InvoiceitemRepository invoiceitemRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public List<PurchaseOrderDto> getOrderHistoryForUser(String userId) {

		List<PurchaseOrder> purchaseOrders = orderRepository.findByUserIdOrderByUpdatedDateDesc(userId);
		List<PurchaseOrderDto> purchaseOrderDtos = new ArrayList<>();
		for (PurchaseOrder purchaseOrder : purchaseOrders) {
			PurchaseOrderDto purchaseOrderDto = mapPurchaseOrder(purchaseOrder);

			purchaseOrderDto.setInvoices(mapInvoices(purchaseOrder));

			purchaseOrderDto.setOrderitems(mapOrderItems(purchaseOrder));

			purchaseOrderDtos.add(purchaseOrderDto);
		}
		return purchaseOrderDtos;
	}

	private PurchaseOrderDto mapPurchaseOrder(PurchaseOrder purchaseOrder) {
		PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
		purchaseOrderDto.setId(purchaseOrder.getId());
		purchaseOrderDto.setCreatedBy(purchaseOrder.getCreatedBy());
		purchaseOrderDto.setCreationDate(purchaseOrder.getCreationDate());
		purchaseOrderDto.setNotes(purchaseOrder.getNotes());
		purchaseOrderDto.setOrderType(purchaseOrder.getOrderType());
		purchaseOrderDto.setUpdatedBy(purchaseOrder.getUpdatedBy());
		purchaseOrderDto.setUpdatedDate(purchaseOrder.getUpdatedDate());
		purchaseOrderDto.setUserId(purchaseOrder.getUserId());
		return purchaseOrderDto;
	}

	private List<OrderitemDto> mapOrderItems(PurchaseOrder purchaseOrder) {
		List<OrderitemDto> orderitemDtos = new ArrayList<>();
		List<Orderitem> orderitems = purchaseOrder.getOrderitems();

		for (Orderitem orderitem : orderitems) {
			Invoiceitem invoiceitem = getInvoiceItemByOrderItemId(purchaseOrder.getInvoices(), orderitem.getId());
			OrderitemDto orderitemDto = mapOrderItem(invoiceitem, orderitem);
			orderitemDtos.add(orderitemDto);
		}
		return orderitemDtos;
	}

	private OrderitemDto mapOrderItem(Invoiceitem invoiceitem, Orderitem orderitem) {
		OrderitemDto orderitemDto = new OrderitemDto();
		orderitemDto.setId(orderitem.getId());
		orderitemDto.setAmount(orderitemDto.getAmount());
		orderitemDto.setCreatedDate(orderitem.getCreatedDate());
		orderitemDto.setOriginalLineItemId(orderitem.getOriginalLineItemId());
		orderitemDto.setQuantity(orderitem.getQuantity());
		orderitemDto.setStatus(orderitem.getStatus());
		orderitemDto.setUpdatedBy(orderitem.getUpdatedBy());
		orderitemDto.setUpdatedDate(orderitem.getUpdatedDate());
		orderitemDto.setQrCode(orderitem.getQrCode());
		orderitemDto.setProduct(mapProduct(orderitem));
		if (null != invoiceitem) {
			InvoiceitemDto invoiceitemDto = new InvoiceitemDto();
			invoiceitemDto.setId(invoiceitem.getId());
			invoiceitemDto.setAmount(invoiceitem.getAmount());
			invoiceitemDto.setCreatedBy(invoiceitem.getCreatedBy());
			invoiceitemDto.setCreatedDate(invoiceitem.getCreatedDate());
			invoiceitemDto.setInvNumber(invoiceitem.getInvNumber());
			invoiceitemDto.setUpdatedBy(invoiceitem.getUpdatedBy());
			invoiceitemDto.setUpdatedDate(invoiceitem.getUpdatedDate());
			orderitemDto.setInvoiceitem(invoiceitemDto);
		}
		return orderitemDto;
	}

	private Invoiceitem getInvoiceItemByOrderItemId(List<Invoice> invoices, String orderItemId) {
		for (Invoice invoice : invoices) {
			List<Invoiceitem> invoiceItems = invoice.getInvoiceitems();
			for (Invoiceitem invoiceitem : invoiceItems) {
				if (invoiceitem.getOrderitem().getId().equals(orderItemId)) {
					return invoiceitem;
				}
			}
		}
		return null;
	}

	private ProductDto mapProduct(Orderitem orderitem) {
		Product product = orderitem.getProduct();
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setCategory(product.getCategory());
		productDto.setDescription(product.getDescription());
		productDto.setManufacturer(product.getManufacturer());
		productDto.setManufacturingDate(product.getManufacturingDate());
		productDto.setName(product.getName());
		productDto.setPicture(product.getPicture());
		productDto.setPrice(product.getPrice());
		productDto.setSize(product.getSize());
		productDto.setQuantity(product.getQuantity());
		productDto.setSku(product.getSku());
		productDto.setUpdatedBy(product.getUpdatedBy());
		productDto.setUpdatedDate(product.getUpdatedDate());
		return productDto;
	}

	private List<InvoiceDto> mapInvoices(PurchaseOrder purchaseOrder) {
		List<Invoice> invoices = purchaseOrder.getInvoices();
		List<InvoiceDto> invoiceDtos = new ArrayList<>();
		for (Invoice invoice : invoices) {
			InvoiceDto invoiceDto = new InvoiceDto();
			invoiceDto.setId(invoice.getId());
			invoiceDto.setCreatedDate(invoice.getCreatedDate());
			invoiceDto.setPaymentMethod(invoice.getPaymentMethod());
			invoiceDto.setTotalAmount(invoice.getTotalAmount());
			invoiceDto.setUpdatedBy(invoice.getUpdatedBy());
			invoiceDto.setUpdatedDate(invoice.getUpdatedDate());

			invoiceDtos.add(invoiceDto);
		}
		return invoiceDtos;
	}

	@Override
	public OrderitemDto getOrderItemById(String orderItemId) {
		Optional<Orderitem> orderitemFromDb = orderitemRepository.findById(orderItemId);
		if (orderitemFromDb.isPresent()) {
			Orderitem orderitem = orderitemFromDb.get();
			OrderitemDto orderitemDto = new OrderitemDto();
			orderitemDto.setId(orderitem.getId());
			orderitemDto.setAmount(orderitemDto.getAmount());
			orderitemDto.setCreatedDate(orderitem.getCreatedDate());
			orderitemDto.setOriginalLineItemId(orderitem.getOriginalLineItemId());
			orderitemDto.setQuantity(orderitem.getQuantity());
			orderitemDto.setStatus(orderitem.getStatus());
			orderitemDto.setUpdatedBy(orderitem.getUpdatedBy());
			orderitemDto.setUpdatedDate(orderitem.getUpdatedDate());
			orderitemDto.setQrCode(orderitem.getQrCode());
			orderitemDto.setProduct(mapProduct(orderitem));
			Invoiceitem invoiceitem = invoiceitemRepository.findByOrderitem(orderitem);

			InvoiceitemDto invoiceitemDto = new InvoiceitemDto();
			if(null != invoiceitem) {
			invoiceitemDto.setId(invoiceitem.getId());
			invoiceitemDto.setAmount(invoiceitem.getAmount());
			invoiceitemDto.setCreatedBy(invoiceitem.getCreatedBy());
			invoiceitemDto.setCreatedDate(invoiceitem.getCreatedDate());
			invoiceitemDto.setInvNumber(invoiceitem.getInvNumber());
			invoiceitemDto.setUpdatedBy(invoiceitem.getUpdatedBy());
			invoiceitemDto.setUpdatedDate(invoiceitem.getUpdatedDate());
			}
			orderitemDto.setInvoiceitem(invoiceitemDto);

			return orderitemDto;
		}
		return null;
	}

	@Override
	public OrderitemDto createOrderItem(@Valid OrderitemRequest orderitemRequest) {

		Orderitem orderitem = new Orderitem();
		double quantity = 1;
		if (null != orderitemRequest.getQuantity()) {
			quantity = orderitemRequest.getQuantity();
			quantity = (quantity == 0) ? 1 : quantity;
		}

		Optional<PurchaseOrder> purchaseOrderOptional = orderRepository.findById(orderitemRequest.getOrderId());
		if (purchaseOrderOptional.isEmpty()) {
			throw new RuntimeException("Cannot find order with order id: " + orderitemRequest.getOrderId());
		}

		PurchaseOrder purchaseOrder = purchaseOrderOptional.get();
		orderitem.setPurchaseorder(purchaseOrder);

		Optional<Product> productOptional = productRepository.findById(orderitemRequest.getProductId());
		if (productOptional.isEmpty()) {
			throw new RuntimeException("Cannot find product with product id: " + orderitemRequest.getProductId());
		}
		Product product = productOptional.get();
		orderitem.setProduct(product);

		double amount = quantity * product.getPrice();
		orderitem.setAmount(amount);
		orderitem.setQuantity(quantity);
		String status = orderitem.getStatus();
		if (null == status) {
			if ("Exchange".equals(orderitemRequest.getType())) {
				status = "Exchange initiated";
			} else {
				status = "Return initiated";
			}
		}
		orderitem.setStatus(status);
		orderitem.setCreatedDate(new Timestamp(new Date().getTime()));
		orderitem.setUpdatedBy(orderitemRequest.getUserId());
		orderitem.setUpdatedDate(new Timestamp(new Date().getTime()));

		orderitem.setQrCode(QrCodeGenerator.generateQrCode(orderitemRequest.getUserId(), 8));

		Orderitem orideritemSaved = orderitemRepository.save(orderitem);

		Invoice invoice = generateInvoice(purchaseOrder, orideritemSaved);

		return mapOrderItem(invoice.getInvoiceitems().get(0), orderitem);
	}

	private Invoice generateInvoice(PurchaseOrder purchaseOrder, Orderitem orideritemSaved) {
		Invoiceitem invoiceitem = new Invoiceitem();
		invoiceitem.setAmount(orideritemSaved.getAmount());
		invoiceitem.setCreatedBy(orideritemSaved.getUpdatedBy());
		invoiceitem.setCreatedDate(new Timestamp(new Date().getTime()));
		invoiceitem.setUpdatedBy(orideritemSaved.getUpdatedBy());
		invoiceitem.setUpdatedDate(new Timestamp(new Date().getTime()));
		invoiceitem.setOrderitem(orideritemSaved);
		invoiceitem.setInvNumber(InvoiceNumberGenerator.generateInvoiceNumber(20));

		List<Invoiceitem> invoiceitems = new ArrayList<>();
		invoiceitems.add(invoiceitem);

		Invoice invoice = new Invoice();
		invoice.setCreatedDate(new Timestamp(new Date().getTime()));
		invoice.setUpdatedBy(orideritemSaved.getUpdatedBy());
		invoice.setUpdatedDate(new Timestamp(new Date().getTime()));
		invoice.setPaymentMethod("Card");
		invoice.setTotalAmount(orideritemSaved.getAmount());
		invoice.setPurchaseorder(purchaseOrder);
		invoice.setInvoiceitems(invoiceitems);

		Invoice invoiceSaved = invoiceRepository.save(invoice);
		return invoiceSaved;
	}

}
