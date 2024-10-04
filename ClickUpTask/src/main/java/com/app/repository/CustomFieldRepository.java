package com.app.repository;

import com.app.entity.CustomField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomFieldRepository extends JpaRepository<CustomField, Long> {
}
