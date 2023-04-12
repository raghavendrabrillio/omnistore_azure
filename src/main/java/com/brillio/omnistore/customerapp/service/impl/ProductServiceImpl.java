package com.brillio.omnistore.customerapp.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.omnistore.customerapp.repository.ProductRepository;
import com.brillio.omnistore.customerapp.service.ProductService;
import com.brillio.omnistore.dto.ProductDto;
import com.brillio.omnistore.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDto> getProducts(String... filter) {
		List<ProductDto> productDtos = new ArrayList<>(0);
		if (null != filter && filter.length > 0) {
			String name = getFilterFromInput(0, filter);
			String brand = getFilterFromInput(1, filter);
			String size = getFilterFromInput(2, filter);
			String price = getFilterFromInput(3, filter);
			String category = getFilterFromInput(4, filter);
			String noofRows = getFilterFromInput(5, filter);
			noofRows = noofRows.replace("%", "");
			if (null == noofRows || noofRows.isEmpty()) {
				noofRows = "10000000";
			}
			Integer rowCount = Integer.valueOf(noofRows);
//			updateProductWithPictures();
			List<Product> products = productRepository.getProducts(name, brand, size, price, category, rowCount);
			productDtos = mapProducts(products);
		}
		return productDtos;
	}

	private void updateProductWithPictures() {
		Map<String, String> files = ReadImages.getFiles();
		for(Entry<String, String> entry: files.entrySet()) {
			Optional<Product> productOp = productRepository.findById(entry.getKey());
			if(productOp.isPresent()) {
				String file = entry.getValue();
				try {
					byte[] bytes = Files.readAllBytes(Paths.get(file));
					Product p = productOp.get();
					p.setPicture(bytes);
					productRepository.save(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	private List<ProductDto> mapProducts(List<Product> products) {

		List<ProductDto> productDtos = new ArrayList<>();
		if (null != products && !products.isEmpty()) {
			for (Product product : products) {
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
				productDtos.add(productDto);
			}
		}
		return productDtos;
	}

	private String getFilterFromInput(int index, String... filter) {
		String result = "%";
		if (filter.length >= index) {
			result += filter[index];
		}
		result += "%";
		result = result.replaceAll("null", "");
		return result;
	}

}
