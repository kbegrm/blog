package com.kem.blog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String text;
    private Date postDate;

    @ManyToOne
    private User author;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Comment replyTo;
    @OneToMany(mappedBy = "replyTo")
    private Set<Comment> replies;
    @OneToMany
    private Set<Vote> votes;
}
