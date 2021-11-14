package com.kem.blog.controller.api;

import com.kem.blog.dto.user.Credentials.CredentialsDto;
import com.kem.blog.dto.user.Credentials.CredentialsUpdateDto;
import com.kem.blog.dto.user.Credentials.RegisterDto;
import com.kem.blog.service.AccountDetailsService;
import com.kem.blog.validation.EmailUpdate;
import com.kem.blog.validation.PasswordUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account-details")
@Validated
public class AccountDetailsController {

    private AccountDetailsService detailsService;

    @Autowired
    public AccountDetailsController(AccountDetailsService detailsService) {
        this.detailsService = detailsService;
    }


    @GetMapping("/register")
    public void register(@Valid @RequestBody RegisterDto dto) {
        detailsService.register(dto);
    }
//    public RegisterDto register() {
//        return new RegisterDto("user", "pass", "user@mail.com");
//    }

    @GetMapping("/signin")
    public String signIn(@Valid @RequestBody CredentialsDto dto) {
        // TODO return token
        return "";
    }

    @PutMapping("/username")
    public void changeUsername(@Valid @RequestBody CredentialsUpdateDto dto) {
        detailsService.changeUsername(dto);
    }

    @PutMapping("/password")
    @Validated(PasswordUpdate.class)
    public void changePassword(@Valid() @RequestBody CredentialsUpdateDto dto) {
        detailsService.changePassword(dto);
    }

    @PutMapping("/email")
    @Validated(EmailUpdate.class)
    public void changeEmail(@Valid @RequestBody CredentialsUpdateDto dto) {
        detailsService.changeEmail(dto);
    }
}
