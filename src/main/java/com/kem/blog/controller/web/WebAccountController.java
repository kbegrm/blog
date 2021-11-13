package com.kem.blog.controller.web;

import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.AccountActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Controller
@RequestMapping("/web/account")
@Validated
public class WebAccountController {

    private AccountActionsService actionsService;

    @Autowired
    public WebAccountController(AccountActionsService actionsService) {
        this.actionsService = actionsService;
    }


    @PostMapping("/sub")
    public void sub(@RequestParam @NotNull Long topicId,
                    @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.subscribe(topicId, userDetails.getUser());
    }

    @PostMapping("/unsub")
    public void unsub(@RequestParam @NotNull Long topicId,
                      @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.unsubscribe(topicId, userDetails.getUser());
    }

    @PostMapping("/follow")
    public void follow(@RequestParam @NotNull UUID followId,
                       @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.follow(followId, userDetails.getUser());
    }

    @PostMapping("/unfollow")
    public void unfollow(@RequestParam @NotNull UUID followId,
                       @AuthenticationPrincipal SecurityUserDetails userDetails) {
        actionsService.unfollow(followId, userDetails.getUser());
    }
}
