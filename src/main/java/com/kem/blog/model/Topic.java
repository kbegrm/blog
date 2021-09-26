package com.kem.blog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Topic {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    @Lob
    private String description;
    private Date creationDate;

    @ManyToOne
    private User creator;
    @OneToMany(mappedBy = "topic")
    private Set<Post> posts;
    @ManyToMany(mappedBy = "subscriptions")
    private Set<User> subscribers;


    public Topic() {
    }

    public Topic(String title, String description, User creator) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.creationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }
}
