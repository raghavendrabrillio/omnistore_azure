package com.brillio.omnistore.customerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Invoiceitem;
import com.brillio.omnistore.model.Orderitem;

@Repository
public interface InvoiceitemRepository extends JpaRepository<Invoiceitem, String> {

	Invoiceitem findByOrderitem(Orderitem orderitem);

}
