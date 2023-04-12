package com.brillio.omnistore.customerapp.service;

import java.util.List;

import javax.validation.Valid;

import com.brillio.omnistore.dto.OrderitemDto;
import com.brillio.omnistore.dto.PurchaseOrderDto;
import com.brillio.omnistore.payload.request.OrderitemRequest;

public interface OrderService {

	List<PurchaseOrderDto> getOrderHistoryForUser(String userId);

	OrderitemDto getOrderItemById(String orderItemId);

	OrderitemDto createOrderItem(@Valid OrderitemRequest orderitemRequest);

}
