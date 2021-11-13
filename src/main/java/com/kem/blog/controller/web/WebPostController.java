package com.kem.blog.controller.web;

import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostUpdateDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Controller
@RequestMapping("/web/post")
public class WebPostController {

    private PostService postService;

    @Autowired
    public WebPostController(PostService postService) {
        this.postService = postService;
    }




    @GetMapping("/create")
    public String create() {
        return "CreatePost";
    }

    @PostMapping("/create")
    public void create(@Valid NewPostDto dto,
                       @AuthenticationPrincipal SecurityUserDetails principal) {
        postService.create(dto, principal.getUser());
    }

    @GetMapping
    public String get(@NotNull @RequestParam Long id) {
        PostDto post = postService.get(id);
        return "Post";
    }

    @PutMapping("/updateTitle")
    void updateTitle(@Valid PostUpdateDto dto,
                     @AuthenticationPrincipal SecurityUserDetails principal) {
        postService.updateTitle(dto);
    }

    @PutMapping("/updateText")
    void updateText(@Valid PostUpdateDto dto,
                    @AuthenticationPrincipal SecurityUserDetails principal) {
        postService.updateText(dto);
    }

    @DeleteMapping("delete")
    void delete(@NotNull @RequestParam Long id,
                @AuthenticationPrincipal SecurityUserDetails principal) {
        postService.deletePost(id);
    }
}
