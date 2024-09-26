package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.entity.TaskFieldValue;
import com.app.service.TaskFieldValueService;

public class TaskFieldValueController {

    @Autowired
    private TaskFieldValueService taskFieldValueService;

    @GetMapping("/{taskId}")
    public Optional<TaskFieldValue> getFieldValuesByTaskId(@PathVariable Long taskId) {
        return taskFieldValueService.getFieldValuesByTaskId(taskId);
    }
}