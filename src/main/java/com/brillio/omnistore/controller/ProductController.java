package com.brillio.omnistore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.omnistore.customerapp.service.ProductService;
import com.brillio.omnistore.dto.ProductDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/omnistore/products")
@SecurityRequirement(name = "omnistore")
@Tag(name = "Product Endpoints")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "size", required = false) String size,
			@RequestParam(name = "price", required = false) String price,
			@RequestParam(name = "category", required = false) String category,
			@RequestParam(name = "noOfRows", required = false) String noOfRows) {
		return new ResponseEntity<>(productService.getProducts(name, brand, size, price, category, noOfRows),
				HttpStatus.OK);
	}

}
