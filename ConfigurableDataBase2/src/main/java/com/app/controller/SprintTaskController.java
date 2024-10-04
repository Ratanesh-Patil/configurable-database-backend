package com.app.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.SprintTask;
import com.app.service.SprintTaskService;

@RestController
@RequestMapping("/api/sprints/{sprintId}/tasks")
@CrossOrigin("*")
public class SprintTaskController {

	@Autowired
	private SprintTaskService sprintTaskService;

	@GetMapping
	public List<SprintTask> getTasksBySprint(@PathVariable Long sprintId) {
		return sprintTaskService.getTasksBySprint(sprintId);
	}

	@PostMapping
	public SprintTask createSprintTask(@PathVariable Long sprintId, @RequestBody SprintTask sprintTask) throws AttributeNotFoundException {
		return sprintTaskService.createSprintTask(sprintId, sprintTask);
	}
}
