package com.kem.blog.model;

import com.kem.blog.model.Vote.PostVote;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "post")
    private Set<PostVote> votes;



    public Post() {
    }

    public Post(String title, String text, User author, Topic topic) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.topic = topic;
        this.postDate = new Date();
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<PostVote> getVotes() {
        return votes;
    }

    public void setVotes(Set<PostVote> votes) {
        this.votes = votes;
    }
}
