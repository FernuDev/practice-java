package com.hexagonal.todo.infrastructure.config;

import com.hexagonal.todo.application.services.TaskService;
import com.hexagonal.todo.application.usecases.*;
import com.hexagonal.todo.domain.ports.out.ExternalServicePort;
import com.hexagonal.todo.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.todo.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.todo.infrastructure.repositories.JpaTaskRepository;
import com.hexagonal.todo.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepository jpaTaskRepository) {
        return new JpaTaskRepositoryAdapter(jpaTaskRepository);
    }

    @Bean
    public ExternalServicePort externalServicePort(RestTemplate restTemplate) {
        return new ExternalServiceAdapter(restTemplate);
    }

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort,
                                   ExternalServicePort externalServicePort) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new GetAdditionalTaskInfoUseCaseImpl(externalServicePort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort)
        );
    }
}
