package com.kem.blog.dto.user;

import java.util.UUID;

public class CredentialsDto {

    private final UUID userId;
    private final String password;

    public CredentialsDto(UUID userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
