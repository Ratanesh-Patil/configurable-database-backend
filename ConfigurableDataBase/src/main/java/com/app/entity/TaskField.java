package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_fields")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fieldName; // Name of the custom field

    @Column(nullable = false)
    private String fieldType; // Type of the custom field (e.g., text, number, date)

    // List of TaskFieldValue entries related to this field
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskFieldValue> fieldValues = new ArrayList<>();
}
