package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.TaskFieldValue;

public interface TaskFieldValueRepository extends JpaRepository<TaskFieldValue, Long> {

	
}