package com.hexagonal.todo.domain.ports.in;

public interface DeleteTaskUseCase {
    Boolean deleteTask(Long id);
}
