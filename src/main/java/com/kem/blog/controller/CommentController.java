package com.kem.blog.controller;

import com.kem.blog.dto.comment.CommentUpdateDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/comment")
@Validated
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping
    void create(@Valid NewCommentDto dto) {
        commentService.create(dto);
    }

    @PutMapping
    void updateText(@Valid CommentUpdateDto dto) {
        commentService.update(dto);
    }

    @DeleteMapping
    void delete(Long commentId) {
        commentService.delete(commentId);
    }
}
