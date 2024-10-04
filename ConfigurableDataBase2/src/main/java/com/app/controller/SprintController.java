package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Sprint;
import com.app.service.SprintService;

@RestController
@RequestMapping("/api/sprints")
@CrossOrigin("*")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @GetMapping
    public List<Sprint> getAllSprints() {
        return sprintService.getAllSprints();
    }
    
    // Get a sprint by its ID
    @GetMapping("/{sprintId}")
    public Sprint getSprintById(@PathVariable Long sprintId) {
        Optional<Sprint> sprint = sprintService.getSprintById(sprintId);
        if (sprint.isPresent()) {
            return sprint.get();
        } else {
            throw new RuntimeException("Sprint not found with ID: " + sprintId); // Handle sprint not found scenario
        }
    }

    @PostMapping
    public Sprint createSprint(@RequestBody Sprint sprint) {
         return sprintService.createSprint(sprint);
    }
}
