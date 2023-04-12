package com.brillio.omnistore.customerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.PurchaseOrder;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder, String> {
	
	List<PurchaseOrder> findByUserIdOrderByUpdatedDateDesc(String userId);

}
