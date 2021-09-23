package com.kem.blog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String text;
    private Date postDate;

    @ManyToOne
    private User author;
    @ManyToOne
    private Topic topic;
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
    @OneToMany
    private Set<Vote> votes;
}
