package com.kem.blog.dto.user;

import java.util.UUID;

public class UserPreviewDto {

    private final UUID id;
    private final String username;

    public UserPreviewDto(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
