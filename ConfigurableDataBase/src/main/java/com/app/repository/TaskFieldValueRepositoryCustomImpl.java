package com.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.app.entity.TaskFieldValue;

public class TaskFieldValueRepositoryCustomImpl implements TaskFieldValueRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public TaskFieldValue merge(TaskFieldValue taskFieldValue) {
        return entityManager.merge(taskFieldValue);
    }
}