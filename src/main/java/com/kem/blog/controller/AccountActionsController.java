package com.kem.blog.controller;

import com.kem.blog.dto.user.Account.AccountDto;
import com.kem.blog.dto.user.Account.FollowDto;
import com.kem.blog.dto.user.Account.SubDto;
import com.kem.blog.service.AccountActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account-actions")
@Validated
public class AccountActionsController {

    private AccountActionsService actionsService;

    @Autowired
    public AccountActionsController(AccountActionsService actionsService) {
        this.actionsService = actionsService;
    }



    @GetMapping
    public AccountDto getAccountInfo(@NotNull @RequestBody String userId) {
        System.out.println(userId);
        UUID uuid = UUID.fromString(userId);
        return actionsService.getAccountInfo(uuid);
    }

    // TODO remove
    @GetMapping("/all")
    public List<UUID> getAllIds() {
        return actionsService.getAllIds();
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubDto dto) {
        actionsService.subscribe(dto);
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody SubDto dto) {
        actionsService.unsubscribe(dto);
    }

    @PostMapping("follow")
    public void follow(@Valid @RequestBody FollowDto dto) {
        actionsService.follow(dto);
    }

    @PostMapping("/unfollow")
    public void unfollow(@Valid @RequestBody FollowDto dto) {
        actionsService.unfollow(dto);
    }
}
