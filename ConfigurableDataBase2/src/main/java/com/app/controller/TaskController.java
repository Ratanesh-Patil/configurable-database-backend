package com.app.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.entity.FieldConfiguration;
import com.app.entity.Task;
import com.app.service.FieldConfigurationService;
import com.app.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FieldConfigurationService fieldConfigurationService;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/add-field/{taskId}")
    public Task addField(@PathVariable Long taskId, @RequestParam String fieldName, @RequestParam String fieldValue) {
        return taskService.addFieldToTask(taskId, fieldName, fieldValue);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Endpoint to get all field configurations
    @GetMapping("/field-configurations")
    public List<FieldConfiguration> getFieldConfigurations() {
        return fieldConfigurationService.getAllFieldConfigurations();
    }

    // Endpoint to create new field configurations
    @PostMapping("/field-configuration")
    public FieldConfiguration createFieldConfiguration(@RequestBody FieldConfiguration fieldConfiguration) {
        return fieldConfigurationService.createFieldConfiguration(fieldConfiguration);
    }
    
    @DeleteMapping("/field-configuration/{id}")
    public void deleteFieldConfiguration(@PathVariable Long id) {
        fieldConfigurationService.deleteFieldConfiguration(id);
    }
    
    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/add-dropdown-field/{taskId}")
    public Task addDropdownField(@PathVariable Long taskId, @RequestBody Map<String, String> fieldData) {
        String fieldName = fieldData.get("fieldName");
        String fieldValue = fieldData.get("fieldValue");
        
        // Validate field configuration here, if necessary
        return taskService.addFieldToTask(taskId, fieldName, fieldValue);
    }

}