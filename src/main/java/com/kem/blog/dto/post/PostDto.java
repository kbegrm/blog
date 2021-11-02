package com.kem.blog.dto.post;

import com.kem.blog.dto.topic.TopicPreviewDto;
import com.kem.blog.dto.comment.CommentDto;
import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PostDto extends PostPreviewDto{

    private final String text;
    private final UserPreviewDto author;
    private final TopicPreviewDto topic;
    private final List<CommentDto> comments;
    private final Long upvotes;
    private final Long downvotes;

    public PostDto(Long id, String title, Date postDate,
                   String text, UserPreviewDto author, TopicPreviewDto topic,
                   List<CommentDto> comments, Long upvotes, Long downvotes) {
        super(id, title, postDate);
        this.text = text;
        this.author = author;
        this.topic = topic;
        this.comments = comments;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public String getText() {
        return text;
    }

    public UserPreviewDto getAuthor() {
        return author;
    }

    public TopicPreviewDto getTopic() {
        return topic;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public Long getDownvotes() {
        return downvotes;
    }
}
