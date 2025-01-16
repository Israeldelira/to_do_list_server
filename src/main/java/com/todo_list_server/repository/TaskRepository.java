package com.todo_list_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo_list_server.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	/**
     * Find Task by status.
     * 
     * @param status (true/false) true(complete) false ( no complete)
     * @return Return list Task complete or not complete.
     */
	List<Task> findByStatus(boolean status);
	
	
}

