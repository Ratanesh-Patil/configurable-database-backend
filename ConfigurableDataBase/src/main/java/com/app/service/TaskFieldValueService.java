package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.entity.TaskFieldValue;
import com.app.repository.TaskFieldValueRepository;

public class TaskFieldValueService {

    @Autowired
    private TaskFieldValueRepository taskFieldValueRepository;

    public Optional<TaskFieldValue> getFieldValuesByTaskId(Long taskId) {
        return taskFieldValueRepository.findById(taskId);
    }
}