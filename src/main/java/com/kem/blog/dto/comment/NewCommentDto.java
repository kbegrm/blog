package com.kem.blog.dto.comment;

import java.util.UUID;

public class NewCommentDto {

    private final UUID authorId;
    private final Long replyToId;
    private final Long PostId;
    private final String text;

    public NewCommentDto(UUID authorId, Long commentId, Long replyToId, Long postId, String text) {
        this.authorId = authorId;
        this.replyToId = replyToId;
        PostId = postId;
        this.text = text;
    }

    public UUID getAuthorId() {
        return authorId;
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
