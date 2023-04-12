package com.brillio.omnistore.customerapp.service;

import java.util.List;

import com.brillio.omnistore.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProducts(String... filter);

}
