package com.kem.blog.model.Vote;

import com.kem.blog.model.Post;
import com.kem.blog.model.User;

import javax.persistence.*;

@Entity
@IdClass(PostVoteId.class)
public class PostVote {

    @Id
    @ManyToOne
    private User voter;
    @Id
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
