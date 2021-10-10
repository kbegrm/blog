package com.kem.blog.controller;

import com.kem.blog.dto.user.AccountCredentialsUpdateDto;
import com.kem.blog.dto.user.CredentialsDto;
import com.kem.blog.dto.user.RegisterDto;
import com.kem.blog.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller("/account-details")
public class AccountDetailsController {

    private AccountDetailsService detailsService;

    @Autowired
    public AccountDetailsController(AccountDetailsService detailsService) {
        this.detailsService = detailsService;
    }



    @GetMapping("/register")
    public void register(RegisterDto dto) {
        detailsService.register(dto);
    }

    @GetMapping("/signin")
    public String signIn(CredentialsDto dto) {
    // TODO return token
    }

    @PutMapping("/username")
    public void changeUsername(AccountCredentialsUpdateDto dto) {
        detailsService.changeUsername(dto);
    }

    @PutMapping("/password")
    public void changePassword(AccountCredentialsUpdateDto dto) {
        detailsService.changePassword(dto);
    }

    @PutMapping("/email")
    public void changeEmail(AccountCredentialsUpdateDto dto) {
        detailsService.changeEmail(dto);
    }
}
