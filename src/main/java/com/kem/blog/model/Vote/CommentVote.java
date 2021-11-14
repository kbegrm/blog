package com.kem.blog.model.Vote;

import com.kem.blog.model.Comment;
import com.kem.blog.model.User;

import javax.persistence.*;

@Entity
public class CommentVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User voter;
    @ManyToOne
    private Comment comment;
    @Enumerated(EnumType.STRING)
    private VoteType vote;


    public CommentVote() {
    }

    public CommentVote(User voter, Comment comment, VoteType vote) {
        this.voter = voter;
        this.comment = comment;
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
