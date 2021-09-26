package com.kem.blog.service;

import com.kem.blog.dto.CommentDto;
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


    void create(CommentDto dto) {
        Long replyToId = dto.getReplyToId();
        Comment comment = new Comment(
                dto.getText(),
                userRepo.getById(dto.getAuthorId()),
                postRepo.getById(dto.getPostId()),
                replyToId == null ? null : commentRepo.getById(replyToId)
        );
        commentRepo.save(comment);
    }

    void update(CommentDto dto) {
        commentRepo.getById(dto.getCommentId()).setText(dto.getText());
    }

    void delete(CommentDto dto) {
        commentRepo.deleteById(dto.getCommentId());
    }
}
