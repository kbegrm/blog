package com.kem.blog.model;

import com.kem.blog.model.Vote.CommentVote;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String text;
    private Date postDate;

    @ManyToOne
    private User author;
    @ManyToOne
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment replyTo;
    @OneToMany(mappedBy = "replyTo")
    private List<Comment> replies;
    @OneToMany(mappedBy = "comment")
    private List<CommentVote> votes;


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

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public List<CommentVote> getVotes() {
        return votes;
    }

    public void setVotes(List<CommentVote> votes) {
        this.votes = votes;
    }
}
