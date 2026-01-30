package com.hexagonal.todo.infrastructure.controllers.dto;

import com.hexagonal.todo.domain.models.Task;

import java.time.LocalDateTime;

/**
 * DTO for sending task data in API responses.
 * This keeps infrastructure concerns separate from domain models.
 */
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Boolean completed;

    public TaskResponse() {}

    public TaskResponse(Long id, String title, String description, LocalDateTime creationDate, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
    }

    /**
     * Creates a TaskResponse from a domain Task model.
     */
    public static TaskResponse fromDomainModel(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.getCompleted()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
