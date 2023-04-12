package com.brillio.omnistore.customerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillio.omnistore.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

	List<Task> findByStatusAndAssignedToOrderByUpdatedDateDesc(String status, String assignedTo);

	List<Task> findByAssignedToOrderByUpdatedDateDesc(String assignedTo);

}
