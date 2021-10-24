package com.kem.blog.controller;

import com.kem.blog.dto.comment.CommentUpdateDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/comment")
@Validated
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping
    void create(@Valid @RequestBody NewCommentDto dto) {
        commentService.create(dto);
    }

    @PutMapping
    void updateText(@Valid @RequestBody CommentUpdateDto dto) {
        commentService.update(dto);
    }

    @DeleteMapping
    void delete(@NotNull @RequestBody Long commentId) {
        commentService.delete(commentId);
    }
}
