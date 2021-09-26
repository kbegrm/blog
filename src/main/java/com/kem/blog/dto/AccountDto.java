package com.kem.blog.dto;

import java.util.UUID;

public class AccountDto {

    private final UUID id;
    private final String username;
    private final String password;
    private final String email;

    public AccountDto(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
