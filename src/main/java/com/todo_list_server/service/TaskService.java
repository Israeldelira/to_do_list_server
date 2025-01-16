package com.todo_list_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo_list_server.model.Task;
import com.todo_list_server.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.isStatus());
            return taskRepository.save(task);
        }
        return null;
    }

    // Delete a task by ID
    public Task deleteTask(Long id) {
        taskRepository.deleteById(id);
		return null;
    }

    // Get tasks by their completion status
    public List<Task> getTasksByCompletionStatus(boolean status) {
        return taskRepository.findByStatus(status);
    }
}