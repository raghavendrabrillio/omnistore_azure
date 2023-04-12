package com.brillio.omnistore.customerapp.service;

import java.util.List;

import com.brillio.omnistore.dto.TaskDto;
import com.brillio.omnistore.payload.request.TaskRequest;

public interface TaskService {

	List<TaskDto> getTasks(String status, String userId);

	TaskDto createTask(TaskRequest taskRequest);

	TaskDto updateTask(String taskId, TaskRequest taskRequest);

	boolean deleteTask(String taskId);
}
