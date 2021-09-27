package com.kem.blog.dto.user;

import java.util.UUID;

public class UserPreviewDto {

    private final UUID userId;
    private final String username;

    public UserPreviewDto(UUID userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
