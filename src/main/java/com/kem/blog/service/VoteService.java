package com.kem.blog.service;

import com.kem.blog.dto.VoteDto;
import com.kem.blog.model.Comment;
import com.kem.blog.model.Post;
import com.kem.blog.model.User;
import com.kem.blog.model.Vote.CommentVote;
import com.kem.blog.model.Vote.PostVote;
import com.kem.blog.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoteService {

    private UserRepo userRepo;
    private CommentVoteRepo commentVoteRepo;
    private PostVoteRepo postVoteRepo;
    private CommentRepo commentRepo;
    private PostRepo postRepo;

    @Autowired
    public VoteService(UserRepo userRepo, CommentVoteRepo commentVoteRepo,
                       PostVoteRepo postVoteRepo, CommentRepo commentRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.commentVoteRepo = commentVoteRepo;
        this.postVoteRepo = postVoteRepo;
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }




    public void voteComment(VoteDto dto) {
        User voter = userRepo.getById(dto.getVoterId());
        Comment comment = commentRepo.getById(dto.getTargetId());
        CommentVote vote = new CommentVote(voter, comment, dto.getType());
        commentVoteRepo.save(vote);
    }

    public void votePost(VoteDto dto) {
        User voter = userRepo.getById(dto.getVoterId());
        Post post = postRepo.getById(dto.getTargetId());
        PostVote vote = new PostVote(voter, post, dto.getType());
        postVoteRepo.save(vote);
    }
}
