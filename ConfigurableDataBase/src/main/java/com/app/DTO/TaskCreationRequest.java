package com.app.DTO;

import java.util.List;

public class TaskCreationRequest {
    private String title;
    private String description;
    private String status;
    private List<TaskFieldValueDto> customFields;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TaskFieldValueDto> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<TaskFieldValueDto> customFields) {
        this.customFields = customFields;
    }
}