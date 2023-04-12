package com.brillio.omnistore.customerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query(nativeQuery = true, value = "select * from omnistore.product where name like :name "
			+ "and manufacturer like :manufacturer and size like :size and price like :price and category like :category limit :noofRows")
	List<Product> getProducts(@Param(value = "name") String name, @Param(value = "manufacturer") String brand,
			@Param(value = "size") String size, @Param(value = "price") String price, @Param(value = "category")String category, @Param(value = "noofRows")int noofRows);

}
