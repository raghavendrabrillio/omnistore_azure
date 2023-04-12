package com.brillio.omnistore.customerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
