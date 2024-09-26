package com.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.TaskCreationRequest;
import com.app.DTO.TaskFieldValueDto;
import com.app.entity.Task;
import com.app.entity.TaskField;
import com.app.entity.TaskFieldValue;
import com.app.repository.TaskFieldRepository;
import com.app.repository.TaskFieldValueRepository;
import com.app.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskFieldRepository taskFieldRepository;

	@Autowired
	private TaskFieldValueRepository taskFieldValueRepository;

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	public List<TaskField> getAllFields() {
		return taskFieldRepository.findAll();
	}

	public TaskField saveField(TaskField field) {
		return taskFieldRepository.save(field);
	}

	// Save task with custom fields
	public Task saveTaskWithFields(TaskCreationRequest taskRequest) {
		// Create the task entity from request
		Task task = new Task();
		task.setTitle(taskRequest.getTitle());
		task.setDescription(taskRequest.getDescription());
		task.setStatus(taskRequest.getStatus() != null ? taskRequest.getStatus() : "pending");

		// Save the task first
		Task savedTask = taskRepository.save(task);

		// Handle custom fields
		if (taskRequest.getCustomFields() != null && !taskRequest.getCustomFields().isEmpty()) {
			for (TaskFieldValueDto fieldDto : taskRequest.getCustomFields()) {
				// Fetch TaskField using fieldId
				TaskField taskField = taskFieldRepository.findById(fieldDto.getFieldId()).orElse(null);
				if (taskField != null) {
					// Create TaskFieldValue
					TaskFieldValue fieldValue = new TaskFieldValue();
					fieldValue.setTask(savedTask);
					fieldValue.setField(taskField);
					fieldValue.setValue(fieldDto.getValue());

					// Save TaskFieldValue
					taskFieldValueRepository.save(fieldValue);
				}
			}
		}

		return savedTask;
	}

}