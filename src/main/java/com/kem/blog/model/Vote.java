package com.kem.blog.model;

import javax.persistence.Entity;

@Entity
public enum Vote {

    UPVOTE(), DOWNVOTE();

    User voter;


    Vote(){}

    Vote(User voter) {
        this.voter = voter;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }
}
