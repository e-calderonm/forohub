package com.foro.dto;

import javax.validation.constraints.NotBlank;

public class TopicDto {
    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @NotBlank
    private String status;

    @NotBlank
    private String author;

    @NotBlank
    private String course;

    // Getters and setters
}
