package com.kem.blog.model.Vote;

import com.kem.blog.model.Post;
import com.kem.blog.model.User;

import javax.persistence.*;

@Entity
public class PostVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User voter;
    @ManyToOne
    private Post post;
    @Enumerated(EnumType.STRING)
    private VoteType vote;


    public PostVote() {
    }

    public PostVote(User voter, Post post, VoteType vote) {
        this.voter = voter;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public VoteType getVote() {
        return vote;
    }

    public void setVote(VoteType vote) {
        this.vote = vote;
    }
}
