package com.kem.blog.dto.user.Credentials;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterDto {

    @NotBlank
    private final String username;
    @NotBlank
    @Length(min = 8)
    private final String password;
    @NotBlank
    @Email
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
