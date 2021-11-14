package com.kem.blog.controller.api;

import com.kem.blog.dto.user.Account.AccountDto;
import com.kem.blog.dto.user.Account.FollowDto;
import com.kem.blog.dto.user.Account.SubDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.AccountActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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



    @GetMapping("/all")
    public List<UUID> getAllIds() {
        return actionsService.getAllIds();
    }   // TODO remove



    @GetMapping
    public AccountDto getAccountInfo(@NotNull @RequestBody UUID id) {       // TODO test
//        UUID uuid = UUID.fromString(userId);
        return actionsService.getAccountInfo(id);
    }

    @PostMapping("/subscribe")
    public void subscribe(@NotNull @RequestBody Long topicId,
                          @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.subscribe(topicId, userDetails.getUser());
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@NotNull @RequestBody Long topicId,
                            @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.unsubscribe(topicId, userDetails.getUser());
    }

    @PostMapping("follow")
    public void follow(@NotNull @RequestBody UUID followedId,
                       @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.follow(followedId, userDetails.getUser());
    }

    @PostMapping("/unfollow")
    public void unfollow(@NotNull @RequestBody UUID followedId,
                         @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.unfollow(followedId, userDetails.getUser());
    }
}
