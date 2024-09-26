package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.TaskField;

public interface TaskFieldRepository extends JpaRepository<TaskField, Long> {
}