package com.app.repository;

import com.app.entity.TaskFieldValue;

public interface TaskFieldValueRepositoryCustom {
    TaskFieldValue merge(TaskFieldValue taskFieldValue);
}