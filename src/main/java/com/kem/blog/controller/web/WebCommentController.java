package com.kem.blog.controller.web;

import com.kem.blog.dto.comment.CommentUpdateDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/web/comment")
public class WebCommentController {

    private CommentService commentService;

    @Autowired
    public WebCommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/create")
    public String create() {
        return "CreateComment";
    }

    @PostMapping("/create")
    public void create(@Valid NewCommentDto dto,
                       @AuthenticationPrincipal SecurityUserDetails principal) {
        commentService.create(dto);
    }

    @GetMapping("/update")
    public String update() {
        return "CommentUpdate";
    }

    @PutMapping("/update")
    public void update(@Valid CommentUpdateDto dto,
                       @AuthenticationPrincipal SecurityUserDetails principal) {
        commentService.update(dto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam @NotNull Long id) {
        commentService.delete(id);
    }
}
