package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    // Properly set cascade and orphanRemoval, ensuring TaskFieldValue gets updated/deleted
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskFieldValue> customFields = new ArrayList<>();
    
    // Helper methods to handle bidirectional relationship
    public void addCustomField(TaskFieldValue fieldValue) {
        customFields.add(fieldValue);
        fieldValue.setTask(this);
    }

    public void removeCustomField(TaskFieldValue fieldValue) {
        customFields.remove(fieldValue);
        fieldValue.setTask(null);
    }
}
