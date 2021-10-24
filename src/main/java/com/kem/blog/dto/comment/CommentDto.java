package com.kem.blog.dto.comment;

import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommentDto {

    private final Long commentId;
    private final String text;
    private final Date postDate;
    private final UserPreviewDto author;
    private final List<CommentDto> replies;
    private final Long upvotes;
    private final Long downvotes;

    public CommentDto(Long commentId, String text, Date postDate,
                      UserPreviewDto author, List<CommentDto> replies,
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

    public List<CommentDto> getReplies() {
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
