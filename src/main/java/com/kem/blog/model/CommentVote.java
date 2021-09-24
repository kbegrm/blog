package com.kem.blog.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class CommentVote {

    @Id
    private User voter;
    @Id
    private Comment comment;
    @Enumerated(EnumType.STRING)
    VoteType vote;


    CommentVote() {
    }

    CommentVote(User voter, Comment comment, VoteType vote) {
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
