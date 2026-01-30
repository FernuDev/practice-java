package com.hexagonal.todo.infrastructure.controllers.dto;

import com.hexagonal.todo.domain.models.AdditionalTaskInfo;

/**
 * DTO for sending additional task info in API responses.
 */
public class AdditionalTaskInfoResponse {
    private Long userId;
    private String userName;
    private String userEmail;

    public AdditionalTaskInfoResponse() {}

    public AdditionalTaskInfoResponse(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    /**
     * Creates an AdditionalTaskInfoResponse from a domain model.
     */
    public static AdditionalTaskInfoResponse fromDomainModel(AdditionalTaskInfo info) {
        return new AdditionalTaskInfoResponse(
                info.getUserId(),
                info.getUserName(),
                info.getUserEmail()
        );
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
