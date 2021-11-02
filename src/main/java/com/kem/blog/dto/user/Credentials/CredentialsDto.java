package com.kem.blog.dto.user.Credentials;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CredentialsDto {

    @NotNull
    private final UUID userId;
    @NotBlank
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
