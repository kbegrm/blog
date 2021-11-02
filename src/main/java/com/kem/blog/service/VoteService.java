package com.kem.blog.service;

import com.kem.blog.dto.VoteDto;
import com.kem.blog.model.Comment;
import com.kem.blog.model.Post;
import com.kem.blog.model.User;
import com.kem.blog.model.Vote.*;
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
        VoteType type = dto.getType();
        User voter = userRepo.getById(dto.getVoterId());
        Comment comment = commentRepo.getById(dto.getTargetId());
        if (type.equals(VoteType.NONE))
            commentVoteRepo.deleteById(new CommentVoteId(voter, comment));
        CommentVote vote = new CommentVote(voter, comment, dto.getType());
        commentVoteRepo.save(vote);
    }

    public void votePost(VoteDto dto) {
        VoteType type = dto.getType();
        User voter = userRepo.getById(dto.getVoterId());
        Post post = postRepo.getById(dto.getTargetId());
        if (type.equals(VoteType.NONE))
            postVoteRepo.deleteById(new PostVoteId(voter, post));
        else {
            PostVote vote = new PostVote(voter, post, type);
            System.out.println("vote type: "+type.name());
            System.out.println("username: "+voter.getUsername());
            System.out.println("post title: "+post.getTitle());
            postVoteRepo.save(vote);
            System.out.println("EEEEEEEEE");
        }
    }
}
