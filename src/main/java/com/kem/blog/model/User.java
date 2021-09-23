package com.kem.blog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private Date registerDate;
    private Boolean enabled;

    @ManyToMany
    private Set<Topic> subscriptions;
    @OneToMany(mappedBy = "creator")
    private Set<Topic> createdTopics;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "voter")
    private Set<Vote> votes;
    @ManyToMany
    private Set<User> followed;
    @ManyToMany(mappedBy = "followed")
    private Set<User> followers;
}
