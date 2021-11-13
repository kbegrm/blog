package com.kem.blog.controller;

import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostUpdateDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/post")
@Validated
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @PostMapping
    public void create(@Valid @RequestBody NewPostDto dto,
                       @AuthenticationPrincipal SecurityUserDetails userDetails) {
        postService.create(dto, userDetails.getUser());
    }

    @GetMapping
    public PostDto get(@NotNull @RequestBody Long postId) {
        return postService.get(postId);
    }

    @PostMapping("/title")
    public void updateTitle(@Valid @RequestBody PostUpdateDto dto) {
        postService.updateTitle(dto);
    }

    @PostMapping("/text")
    public void updateText(@Valid @RequestBody PostUpdateDto dto) {
        postService.updateText(dto);
    }

    @DeleteMapping
    public void delete(@NotNull @RequestBody Long postId) {
        postService.deletePost(postId);
    }
}
