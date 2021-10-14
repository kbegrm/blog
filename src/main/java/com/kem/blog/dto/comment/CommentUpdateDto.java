package com.kem.blog.dto.comment;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentUpdateDto {

    @NotNull
    private final Long commentId;
    @NotEmpty
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
