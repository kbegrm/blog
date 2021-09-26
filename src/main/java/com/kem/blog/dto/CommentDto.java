package com.kem.blog.dto;

import java.util.UUID;

public class CommentDto {

    private final UUID authorId;
    private final Long commentId;
    private final Long replyToId;
    private final Long PostId;
    private final String text;

    public CommentDto(UUID authorId, Long commentId, Long replyToId, Long postId, String text) {
        this.authorId = authorId;
        this.commentId = commentId;
        this.replyToId = replyToId;
        PostId = postId;
        this.text = text;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public Long getReplyToId() {
        return replyToId;
    }

    public Long getPostId() {
        return PostId;
    }

    public String getText() {
        return text;
    }
}
