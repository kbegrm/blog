package com.kem.blog.model;

import javax.persistence.Entity;

@Entity
public enum Vote {

    UPVOTE(), DOWNVOTE();


    Vote(){}

    Vote(User voter) {
        this.voter = voter;
    }

    User voter;
}
