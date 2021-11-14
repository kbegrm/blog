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
import java.util.Optional;

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


    public void voteComment(VoteDto dto, User voter) {
        VoteType type = dto.getType();
        Comment comment = commentRepo.getById(dto.getTargetId());
        Optional<CommentVote> existingVote = commentVoteRepo.findByVoterAndComment(voter, comment);

        if (existingVote.isPresent()){
            CommentVote vote = existingVote.get();
            if (vote.getVote().equals(type))
                commentVoteRepo.deleteById(vote.getId());
            else
                vote.setVote(type);
        }
        else
            commentVoteRepo.save(new CommentVote(voter, comment, dto.getType()));
    }

    public void votePost(VoteDto dto, User voter) {
        VoteType type = dto.getType();
        Post post = postRepo.getById(dto.getTargetId());
        Optional<PostVote> existingVote = postVoteRepo.findByVoterAndPost(voter, post);

        if (existingVote.isPresent()){
            PostVote vote = existingVote.get();
            if (vote.getVote().equals(type))
                postVoteRepo.deleteById(vote.getId());
            else
                vote.setVote(type);
        }
        else
            postVoteRepo.save(new PostVote(voter, post, dto.getType()));
    }
}
