package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.comment.CommentUpdateDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.model.Comment;
import com.kem.blog.repository.CommentRepo;
import com.kem.blog.repository.PostRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentService {

    private CommentRepo commentRepo;
    private UserRepo userRepo;
    private PostRepo postRepo;

    public CommentService(CommentRepo commentRepo, UserRepo userRepo, PostRepo postRepo) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }


    void create(NewCommentDto dto) {
        Comment comment = Mapper.dtoToComment(dto);
        commentRepo.save(comment);
    }

    void update(CommentUpdateDto dto) {
        commentRepo.getById(dto.getCommentId()).setText(dto.getText());
    }

    void delete(CommentUpdateDto dto) {
        commentRepo.getById(dto.getCommentId()).setText("[deleted]");
    }
}
