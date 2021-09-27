package com.kem.blog.dto.comment;

public class CommentUpdateDto {

    private final Long commentId;
    private final String text;

    public CommentUpdateDto(Long commentId, String text) {
        this.commentId = commentId;
        this.text = text;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }
}
