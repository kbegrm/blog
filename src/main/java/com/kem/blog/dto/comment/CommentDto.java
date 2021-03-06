package com.kem.blog.dto.comment;

import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Date;
import java.util.List;

public class CommentDto {

    private final Long id;
    private final String text;
    private final Date postDate;
    private final UserPreviewDto author;
    private final Long upvotes;
    private final Long downvotes;

    public CommentDto(Long id, String text, Date postDate,UserPreviewDto author,
                      Long upvotes, Long downvotes) {
        this.id = id;
        this.text = text;
        this.postDate = postDate;
        this.author = author;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public Long getId() {
        return id;
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

    public Long getUpvotes() {
        return upvotes;
    }

    public Long getDownvotes() {
        return downvotes;
    }
}
