package com.kem.blog.model.Vote;

import com.kem.blog.model.Post;
import com.kem.blog.model.User;

import java.io.Serializable;
import java.util.Objects;

public class PostVoteId implements Serializable {

    private User voter;
    private Post post;


    public PostVoteId() {
    }

    public PostVoteId(User voter, Post post) {
        this.voter = voter;
        this.post = post;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostVoteId)) return false;
        PostVoteId that = (PostVoteId) o;
        return getVoter().equals(that.getVoter()) && getPost().equals(that.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoter(), getPost());
    }
}
