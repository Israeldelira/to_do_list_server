package com.todo_list_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.todo_list_server.model.Task;
import com.todo_list_server.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		return tasks;
	}

	@PostMapping
	public Task createTask(@Valid @RequestBody Task task) {
		Task createdTask = taskService.createTask(task);
		return createdTask;
//		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task taskUpdate) {
		Task updatedTask = taskService.updateTask(id, taskUpdate);
		return updatedTask;
//		return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	}

	@DeleteMapping("/{taskId}")
	public Task deleteTask(@PathVariable Long taskId) {
		return taskService.deleteTask(taskId);
	}

	@GetMapping("/filter")
	public List<Task> filterTasks(@RequestParam(name = "isComplete", required = false) Boolean is_complete) {
		return taskService.getTasksByCompletionStatus(is_complete);
	}
}
