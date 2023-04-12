package com.brillio.omnistore.customerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Parkinglot;

@Repository
public interface ParkingLotRepository extends JpaRepository<Parkinglot, String> {

	List<Parkinglot> findByStatus(String status);

	List<Parkinglot> findByParkingLotNum(String parkingLotNum);

}
