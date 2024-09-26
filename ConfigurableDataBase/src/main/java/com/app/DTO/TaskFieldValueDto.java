package com.app.DTO;
public class TaskFieldValueDto {
    private Long fieldId; // ID of the field
    private String value; // Value of the custom field

    // Getters and setters
    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}