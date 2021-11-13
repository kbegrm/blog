package com.kem.blog.model;

import com.kem.blog.model.Vote.CommentVote;
import com.kem.blog.model.Vote.PostVote;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    private List<Topic> subscriptions;
    @OneToMany(mappedBy = "creator")
    private List<Topic> createdTopics;
    @OneToMany(mappedBy = "author")
    private List<Post> posts;
    @OneToMany(mappedBy = "author")
    private List<Comment> comments;
    @OneToMany(mappedBy = "voter")
    private List<PostVote> postVotes;
    @OneToMany(mappedBy = "voter")
    private List<CommentVote> commentVotes;
    @ManyToMany
    private List<User> followed;
    @ManyToMany(mappedBy = "followed")
    private List<User> followers;



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

    public List<Topic> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Topic> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Topic> getCreatedTopics() {
        return createdTopics;
    }

    public void setCreatedTopics(List<Topic> createdTopics) {
        this.createdTopics = createdTopics;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getFollowed() {
        return followed;
    }

    public void setFollowed(List<User> followed) {
        this.followed = followed;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<PostVote> getPostVotes() {
        return postVotes;
    }

    public void setPostVotes(List<PostVote> postVotes) {
        this.postVotes = postVotes;
    }

    public List<CommentVote> getCommentVotes() {
        return commentVotes;
    }

    public void setCommentVotes(List<CommentVote> commentVotes) {
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
