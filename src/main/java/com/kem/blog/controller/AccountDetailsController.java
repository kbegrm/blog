package com.kem.blog.controller;

import com.kem.blog.dto.user.CredentialsUpdateDto;
import com.kem.blog.dto.user.CredentialsDto;
import com.kem.blog.dto.user.RegisterDto;
import com.kem.blog.service.AccountDetailsService;
import com.kem.blog.validation.EmailUpdate;
import com.kem.blog.validation.PasswordUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/account-details")
@Validated
public class AccountDetailsController {

    private AccountDetailsService detailsService;

    @Autowired
    public AccountDetailsController(AccountDetailsService detailsService) {
        this.detailsService = detailsService;
    }


    @GetMapping("/register")
    public void register(@Valid RegisterDto dto) {
        detailsService.register(dto);
    }

    @GetMapping("/signin")
    public String signIn(@Valid CredentialsDto dto) {
        // TODO return token
        return "";
    }

    @PutMapping("/username")
    public void changeUsername(@Valid CredentialsUpdateDto dto) {
        detailsService.changeUsername(dto);
    }

    @PutMapping("/password")
    @Validated(PasswordUpdate.class)
    public void changePassword(@Valid() CredentialsUpdateDto dto) {
        detailsService.changePassword(dto);
    }

    @PutMapping("/email")
    @Validated(EmailUpdate.class)
    public void changeEmail(@Valid CredentialsUpdateDto dto) {
        detailsService.changeEmail(dto);
    }
}
