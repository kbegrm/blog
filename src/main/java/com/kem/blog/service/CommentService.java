package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.comment.CommentUpdateDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.model.Comment;
import com.kem.blog.repository.CommentRepo;
import com.kem.blog.repository.PostRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentService {

    private CommentRepo commentRepo;
    private UserRepo userRepo;
    private PostRepo postRepo;
    private Mapper mapper;


    @Autowired
    public CommentService(CommentRepo commentRepo, UserRepo userRepo, PostRepo postRepo, Mapper mapper) {
        this.commentRepo = commentRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.mapper = mapper;
    }


    public void create(NewCommentDto dto) {
        Comment comment = mapper.dtoToComment(dto);
        commentRepo.save(comment);
    }

    public void update(CommentUpdateDto dto) {
        commentRepo.getById(dto.getCommentId()).setText(dto.getText());
    }

    public void delete(Long id) {
        commentRepo.getById(id).setText("[deleted]");
    }
}
