package com.kem.blog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Topic {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String description;
    private Date postDate;

    @ManyToOne
    private User creator;
    @OneToMany(mappedBy = "topic")
    private Set<Post> posts;
    @ManyToMany(mappedBy = "subscriptions")
    private Set<User> subscribers;
}
