package com.hexagonal.todo.infrastructure.controllers;

import com.hexagonal.todo.application.services.TaskService;
import com.hexagonal.todo.domain.models.AdditionalTaskInfo;
import com.hexagonal.todo.domain.models.Task;
import com.hexagonal.todo.infrastructure.controllers.dto.AdditionalTaskInfoResponse;
import com.hexagonal.todo.infrastructure.controllers.dto.TaskRequest;
import com.hexagonal.todo.infrastructure.controllers.dto.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Task operations.
 * Acts as a driving adapter in hexagonal architecture.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create a new task.
     * POST /api/tasks
     */
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        Task task = request.toDomainModel();
        Task createdTask = taskService.createTask(task);
        TaskResponse response = TaskResponse.fromDomainModel(createdTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Get all tasks.
     * GET /api/tasks
     */
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskResponse> responses = tasks.stream()
                .map(TaskResponse::fromDomainModel)
                .toList();
        return ResponseEntity.ok(responses);
    }

    /**
     * Get a specific task by ID.
     * GET /api/tasks/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return taskService.getTask(id)
                .map(task -> ResponseEntity.ok(TaskResponse.fromDomainModel(task)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update an existing task.
     * PUT /api/tasks/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequest request) {

        // First get the existing task to preserve creation date
        return taskService.getTask(id)
                .map(existingTask -> {
                    Task updateTask = request.toDomainModel(id, existingTask.getCreationDate());
                    return taskService.updateTask(id, updateTask)
                            .map(updated -> ResponseEntity.ok(TaskResponse.fromDomainModel(updated)))
                            .orElse(ResponseEntity.notFound().build());
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete a task by ID.
     * DELETE /api/tasks/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Boolean deleted = taskService.deleteTask(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Get additional task info from external service.
     * GET /api/tasks/{id}/info
     */
    @GetMapping("/{id}/info")
    public ResponseEntity<AdditionalTaskInfoResponse> getAdditionalTaskInfo(@PathVariable Long id) {
        // First verify the task exists
        return taskService.getTask(id)
                .map(task -> {
                    AdditionalTaskInfo info = taskService.getAdditionalTaskInfo(id);
                    return ResponseEntity.ok(AdditionalTaskInfoResponse.fromDomainModel(info));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Mark a task as completed.
     * PATCH /api/tasks/{id}/complete
     */
    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskResponse> markTaskAsCompleted(@PathVariable Long id) {
        return taskService.getTask(id)
                .map(existingTask -> {
                    existingTask.setCompleted(true);
                    return taskService.updateTask(id, existingTask)
                            .map(updated -> ResponseEntity.ok(TaskResponse.fromDomainModel(updated)))
                            .orElse(ResponseEntity.notFound().build());
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
