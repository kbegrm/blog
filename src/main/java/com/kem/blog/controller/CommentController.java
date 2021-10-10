package com.kem.blog.controller;

import com.kem.blog.dto.comment.CommentUpdateDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping
    void create(NewCommentDto dto) {
        commentService.create(dto);
    }

    @PutMapping
    void updateText(CommentUpdateDto dto) {
        commentService.update(dto);
    }

    @DeleteMapping
    void delete(Long commentId) {
        commentService.delete(commentId);
    }
}
