package com.brillio.omnistore.customerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

	List<Schedule> findByUserIdOrderByStatusAscUpdatedDateDesc(String userId);
}
