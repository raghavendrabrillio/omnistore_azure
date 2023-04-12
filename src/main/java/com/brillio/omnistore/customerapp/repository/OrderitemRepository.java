package com.brillio.omnistore.customerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Orderitem;

@Repository
public interface OrderitemRepository extends JpaRepository<Orderitem, String> {

}
