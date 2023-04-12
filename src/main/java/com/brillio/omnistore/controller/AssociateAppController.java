package com.brillio.omnistore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.omnistore.customerapp.service.TaskService;
import com.brillio.omnistore.dto.TaskDto;
import com.brillio.omnistore.payload.request.TaskRequest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/omnistore/associate")
@SecurityRequirement(name = "omnistore")
@Tag(name = "Associate Endpoints")
public class AssociateAppController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks/{userId}")
	public ResponseEntity<List<TaskDto>> getTasks(@PathVariable(value = "userId") String userId,
			@RequestParam(name = "status") Optional<String> status) {
		return new ResponseEntity<>(taskService.getTasks(status.orElseGet(() -> ""), userId), HttpStatus.OK);
	}

	@PostMapping("/tasks")
	public TaskDto createTask(@Valid @RequestBody TaskRequest taskRequest) {
		return taskService.createTask(taskRequest);
	}

	@PutMapping("/tasks/{taskId}")
	public TaskDto updateTask(@PathVariable(value = "taskId") String taskId,
			@Valid @RequestBody TaskRequest taskRequest) {
		return taskService.updateTask(taskId, taskRequest);
	}

	@DeleteMapping("/tasks/{taskId}")
	public String deleteTask(@PathVariable(value = "taskId") String taskId) {
		boolean isDeleteSucccess = taskService.deleteTask(taskId);
		if (isDeleteSucccess)
			return "Successfully deleted Task";

		return "Error in deleting Task with Id: " + taskId;
	}

}
