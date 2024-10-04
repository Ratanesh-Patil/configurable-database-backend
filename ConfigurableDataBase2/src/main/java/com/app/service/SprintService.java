package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Sprint;
import com.app.repository.SprintRepository;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    public Sprint createSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }
    
    // Get a sprint by its ID
    public Optional<Sprint> getSprintById(Long sprintId) {
        return sprintRepository.findById(sprintId);
    }
}
