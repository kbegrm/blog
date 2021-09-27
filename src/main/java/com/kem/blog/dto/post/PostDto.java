package com.kem.blog.dto.post;

import com.kem.blog.dto.topic.TopicPreviewDto;
import com.kem.blog.dto.comment.CommentDto;
import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Collection;
import java.util.Date;

public class PostDto {

    private final Long postId;
    private final String title;
    private final String text;
    private final Date postDate;
    private final UserPreviewDto author;
    private final TopicPreviewDto topic;
    private final Collection<CommentDto> comments;
    private final Long upvotes;
    private final Long downvotes;

    public PostDto(Long postId, String title, String text, Date postDate,
                   UserPreviewDto author, TopicPreviewDto topic,
                   Collection<CommentDto> comments, Long upvotes, Long downvotes) {
        this.postId = postId;
        this.title = title;
        this.text = text;
        this.postDate = postDate;
        this.author = author;
        this.topic = topic;
        this.comments = comments;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getPostDate() {
        return postDate;
    }

    public UserPreviewDto getAuthor() {
        return author;
    }

    public TopicPreviewDto getTopic() {
        return topic;
    }

    public Collection<CommentDto> getComments() {
        return comments;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public Long getDownvotes() {
        return downvotes;
    }
}
