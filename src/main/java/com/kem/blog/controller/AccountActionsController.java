package com.kem.blog.controller;

import com.kem.blog.dto.user.AccountDto;
import com.kem.blog.dto.user.FollowDto;
import com.kem.blog.dto.user.SubDto;
import com.kem.blog.service.AccountActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController("/account-actions")
@Validated
public class AccountActionsController {

    private AccountActionsService actionsService;

    @Autowired
    public AccountActionsController(AccountActionsService actionsService) {
        this.actionsService = actionsService;
    }



    @GetMapping
    public AccountDto getAccountInfo(UUID userId) {
        return actionsService.getAccountInfo(userId);
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid SubDto dto) {
        actionsService.subscribe(dto);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid SubDto dto) {
        actionsService.unsubscribe(dto);
    }

    @PostMapping("follow")
    public void follow(@Valid FollowDto dto) {
        actionsService.follow(dto);
    }

    @PostMapping("/unfollow")
    public void unfollow(@Valid FollowDto dto) {
        actionsService.unfollow(dto);
    }
}
