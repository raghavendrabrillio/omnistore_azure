package com.brillio.omnistore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.omnistore.customerapp.service.OrderService;
import com.brillio.omnistore.dto.OrderitemDto;
import com.brillio.omnistore.dto.PurchaseOrderDto;
import com.brillio.omnistore.payload.request.OrderitemRequest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/omnistore/orders")
@SecurityRequirement(name = "omnistore")
@Tag(name = "Order Endpoints")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{userId}")
	public ResponseEntity<List<PurchaseOrderDto>> getOrderHistory(@PathVariable(value = "userId") String userId) {
		return new ResponseEntity<>(orderService.getOrderHistoryForUser(userId), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<OrderitemDto> createOrderItem(@Valid @RequestBody OrderitemRequest orderitemRequest) {
		return new ResponseEntity<>(orderService.createOrderItem(orderitemRequest), HttpStatus.OK);
	}

}
