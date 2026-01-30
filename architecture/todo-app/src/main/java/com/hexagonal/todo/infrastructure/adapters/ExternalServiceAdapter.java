package com.hexagonal.todo.infrastructure.adapters;

import com.hexagonal.todo.domain.models.AdditionalTaskInfo;
import com.hexagonal.todo.domain.ports.out.ExternalServicePort;
import org.springframework.web.client.RestTemplate;

/**
 * Adapter that implements ExternalServicePort to fetch additional task info
 * from an external API (JSONPlaceholder for demo purposes).
 */
public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;
    private static final String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com/users/";

    public ExternalServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        try {
            // Using taskId as userId for demo (maps to JSONPlaceholder users 1-10)
            Long userId = (taskId % 10) + 1;
            UserResponse response = restTemplate.getForObject(
                    EXTERNAL_API_URL + userId,
                    UserResponse.class
            );

            if (response != null) {
                return new AdditionalTaskInfo(
                        response.getId(),
                        response.getName(),
                        response.getEmail()
                );
            }
        } catch (Exception e) {
            // Log error and return default info
            System.err.println("Error fetching external user info: " + e.getMessage());
        }

        return new AdditionalTaskInfo(0L, "Unknown", "unknown@example.com");
    }

    /**
     * DTO for deserializing JSONPlaceholder user response
     */
    private static class UserResponse {
        private Long id;
        private String name;
        private String email;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
