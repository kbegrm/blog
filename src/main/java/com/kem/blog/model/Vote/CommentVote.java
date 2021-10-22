package com.kem.blog.model.Vote;

import com.kem.blog.model.Comment;
import com.kem.blog.model.User;

import javax.persistence.*;

@Entity
@IdClass(CommentVoteId.class)
public class CommentVote {

    @Id
    @ManyToOne
    private User voter;
    @Id
    @ManyToOne
    private Comment comment;
    @Enumerated(EnumType.STRING)
    VoteType vote;


    public CommentVote() {
    }

    public CommentVote(User voter, Comment comment, VoteType vote) {
        this.voter = voter;
        this.comment = comment;
        this.vote = vote;
    }


    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public VoteType getVote() {
        return vote;
    }

    public void setVote(VoteType vote) {
        this.vote = vote;
    }
}
