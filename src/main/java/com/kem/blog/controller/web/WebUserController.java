package com.kem.blog.controller.web;

import com.kem.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Controller
@RequestMapping("web//user")
@Validated
public class WebUserController {

    private UserService userService;

    @Autowired
    public WebUserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/id")
    public String getById(@RequestParam @NotNull UUID id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "User";
    }

    @GetMapping("/username")
    public String getByUsername(@RequestParam @NotNull String username, Model model) {
        model.addAttribute("users", userService.getByUsername(username));
        return "Users";
    }
}
