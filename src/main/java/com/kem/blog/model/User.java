package com.kem.blog.model;

import com.kem.blog.model.Vote.CommentVote;
import com.kem.blog.model.Vote.PostVote;

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
    @Enumerated(EnumType.STRING)
    private Role role;

//    private Set<Role> roles;
//    private Set<Authorities> authorities;

    @ManyToMany
    private Set<Topic> subscriptions;
    @OneToMany(mappedBy = "creator")
    private Set<Topic> createdTopics;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "voter")
    private Set<PostVote> postVotes;
    @OneToMany(mappedBy = "voter")
    private Set<CommentVote> commentVotes;
    @ManyToMany
    private Set<User> followed;
    @ManyToMany(mappedBy = "followed")
    private Set<User> followers;



    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = false;
        this.registerDate = new Date();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Topic> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Topic> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<Topic> getCreatedTopics() {
        return createdTopics;
    }

    public void setCreatedTopics(Set<Topic> createdTopics) {
        this.createdTopics = createdTopics;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<User> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<User> followed) {
        this.followed = followed;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<PostVote> getPostVotes() {
        return postVotes;
    }

    public void setPostVotes(Set<PostVote> postVotes) {
        this.postVotes = postVotes;
    }

    public Set<CommentVote> getCommentVotes() {
        return commentVotes;
    }

    public void setCommentVotes(Set<CommentVote> commentVotes) {
        this.commentVotes = commentVotes;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }

//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

//    public Set<Authorities> getAuthorities() {
//        return authorities;
//    }

//    public void setAuthorities(Set<Authorities> authorities) {
//        this.authorities = authorities;
//    }
}
