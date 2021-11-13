package com.kem.blog.controller.web;

import com.kem.blog.dto.user.Credentials.CredentialsUpdateDto;
import com.kem.blog.dto.user.Credentials.RegisterDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.AccountDetailsService;
import com.kem.blog.validation.EmailUpdate;
import com.kem.blog.validation.PasswordUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("web/credentials")
@Validated
public class WebCredentialsController {

    private AccountDetailsService detailsService;

    @Autowired
    public WebCredentialsController(AccountDetailsService detailsService) {
        this.detailsService = detailsService;
    }




    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @PostMapping("register")
    public String register(@Valid RegisterDto dto) {
        detailsService.register(dto);
        return "Welcome";
    }

    @GetMapping("/login")
    public String signIn() {
        return "Login";
    }

    @PutMapping("/username")
    public void changeUsername(@Valid CredentialsUpdateDto dto,
                               @AuthenticationPrincipal SecurityUserDetails principal) {
        detailsService.changeUsername(dto);
    }

    @PutMapping("/password")
    @Validated(PasswordUpdate.class)
    public void changePassword(@Valid CredentialsUpdateDto dto,
                               @AuthenticationPrincipal SecurityUserDetails principal) {
        detailsService.changePassword(dto);
    }

    @PutMapping("/email")
    @Validated(EmailUpdate.class)
    public void changeEmail(@Valid CredentialsUpdateDto dto,
                            @AuthenticationPrincipal SecurityUserDetails principal) {
        detailsService.changeEmail(dto);
    }
}
