package com.kem.blog.dto.comment;

import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Date;
import java.util.Set;

public class CommentDto {

    private final Long commentId;
    private final String text;
    private final Date postDate;
    private final Set<CommentDto> replies;
    private final UserPreviewDto author;
    private final Long upvotes;
    private final Long downvotes;

    public CommentDto(Long commentId, String text, Date postDate,
                      Set<CommentDto> replies, UserPreviewDto author,
                      Long upvotes, Long downvotes) {
        this.commentId = commentId;
        this.text = text;
        this.postDate = postDate;
        this.replies = replies;
        this.author = author;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public Date getPostDate() {
        return postDate;
    }

    public Set<CommentDto> getReplies() {
        return replies;
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
