package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.FieldConfiguration;
import com.app.repository.FieldConfigurationRepository;

@Service
public class FieldConfigurationService {

    @Autowired
    private FieldConfigurationRepository fieldConfigurationRepository;

    public List<FieldConfiguration> getAllFieldConfigurations() {
        return fieldConfigurationRepository.findAll();
    }

    public FieldConfiguration createFieldConfiguration(FieldConfiguration fieldConfig) {
        return fieldConfigurationRepository.save(fieldConfig);
    }
    
    public void deleteFieldConfiguration(Long id) {
        fieldConfigurationRepository.deleteById(id);
    }
}
