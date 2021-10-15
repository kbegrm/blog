package com.kem.blog.controller;

import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostUpdateDto;
import com.kem.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/post")
@Validated
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @PostMapping
    public void create(@Valid NewPostDto dto) {
        postService.create(dto);
    }

    @GetMapping
    public PostDto get(Long postId) {
        return postService.get(postId);
    }

    @PostMapping("/title")
    public void updateTitle(@Valid PostUpdateDto dto) {
        postService.updateTitle(dto);
    }

    @PostMapping("/text")
    public void updateText(@Valid PostUpdateDto dto) {
        postService.updateText(dto);
    }

    @DeleteMapping
    public void delete(Long postId) {
        postService.deletePost(postId);
    }
}
