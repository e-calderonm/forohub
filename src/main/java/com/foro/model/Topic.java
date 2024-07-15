package com.foro.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @NotBlank
    private String status;

    @NotBlank
    private String author;

    @NotBlank
    private String course;

    // Getters and setters
}
