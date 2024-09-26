package com.app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.FieldConfiguration;

@Repository
public interface FieldConfigurationRepository extends JpaRepository<FieldConfiguration, Long> {
    List<FieldConfiguration> findAll();
}