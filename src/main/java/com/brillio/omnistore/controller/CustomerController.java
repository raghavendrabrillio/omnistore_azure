package com.brillio.omnistore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.omnistore.dto.UserDto;
import com.brillio.omnistore.user.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/omnistore/customer")
@SecurityRequirement(name = "omnistore")
@Tag(name = "Customer Endpoints")
public class CustomerController {

	@Autowired
	private UserService userService;

	@GetMapping("/profile/{userId}")
	public ResponseEntity<UserDto> getCustomerProfile(@PathVariable(value = "userId") String userId) {
		return new ResponseEntity<>(userService.getCustomerProfile(userId), HttpStatus.OK);
	}

}
