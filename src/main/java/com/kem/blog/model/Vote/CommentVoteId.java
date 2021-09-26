package com.kem.blog.model.Vote;

import com.kem.blog.model.Comment;
import com.kem.blog.model.User;

import java.io.Serializable;
import java.util.Objects;

public class CommentVoteId implements Serializable {

    private User voter;
    private Comment comment;



    public CommentVoteId() {
    }

    public CommentVoteId(User voter, Comment comment) {
        this.voter = voter;
        this.comment = comment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentVoteId)) return false;
        CommentVoteId that = (CommentVoteId) o;
        return getVoter().equals(that.getVoter()) && getComment().equals(that.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoter(), getComment());
    }

}
