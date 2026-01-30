package com.hexagonal.todo.infrastructure.controllers.dto;

import com.hexagonal.todo.domain.models.Task;

import java.time.LocalDateTime;

/**
 * DTO for receiving task data in API requests.
 * This keeps infrastructure concerns separate from domain models.
 */
public class TaskRequest {
    private String title;
    private String description;
    private Boolean completed;

    public TaskRequest() {}

    public TaskRequest(String title, String description, Boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    /**
     * Converts this request DTO to a domain Task model.
     * Sets creation date to now and completed to false if not provided.
     */
    public Task toDomainModel() {
        return new Task(
                null,
                this.title,
                this.description,
                LocalDateTime.now(),
                this.completed != null ? this.completed : false
        );
    }

    /**
     * Converts this request DTO to a domain Task model with a specific ID.
     * Used for update operations.
     */
    public Task toDomainModel(Long id, LocalDateTime creationDate) {
        return new Task(
                id,
                this.title,
                this.description,
                creationDate,
                this.completed != null ? this.completed : false
        );
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
