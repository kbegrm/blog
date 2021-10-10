package com.kem.blog.dto.user;

public class RegisterDto {

    private final String username;
    private final String password;
    private final String email;

    public RegisterDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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
