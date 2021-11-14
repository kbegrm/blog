package com.kem.blog.controller.api;

import com.kem.blog.dto.user.UserDto;
import com.kem.blog.dto.user.UserPreviewDto;
import com.kem.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/id")
    public UserDto get(@NotNull @RequestBody UUID id) {
        return userService.getById(id);
    }

    @GetMapping("/username")
    public Collection<UserPreviewDto> get(@NotNull @RequestBody String username) {
        return userService.getByUsername(username);
    }
}
