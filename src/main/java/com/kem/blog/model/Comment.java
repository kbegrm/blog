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


    public Comment() {
    }

    public Comment(String text, User author, Post post, Comment replyTo) {
        this.text = text;
        this.author = author;
        this.post = post;
        this.replyTo = replyTo;
        this.postDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Comment replyTo) {
        this.replyTo = replyTo;
    }

    public Set<Comment> getReplies() {
        return replies;
    }

    public void setReplies(Set<Comment> replies) {
        this.replies = replies;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}
