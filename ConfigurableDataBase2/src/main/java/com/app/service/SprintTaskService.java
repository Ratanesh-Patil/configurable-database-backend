package com.app.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Sprint;
import com.app.entity.SprintTask;
import com.app.repository.SprintRepository;
import com.app.repository.SprintTaskRepository;

@Service
public class SprintTaskService {

    @Autowired
    private SprintTaskRepository sprintTaskRepository;
    @Autowired
    private SprintRepository sprintRepository;

    public List<SprintTask> getTasksBySprint(Long sprintId) {
        return sprintTaskRepository.findBySprintId(sprintId);
    }

    public SprintTask createSprintTask(Long sprintId, SprintTask sprintTask) throws AttributeNotFoundException {
        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new AttributeNotFoundException("Sprint not found"));
        sprintTask.setSprint(sprint);
        return sprintTaskRepository.save(sprintTask);
    }
}
