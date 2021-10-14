package com.kem.blog.dto.comment;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class NewCommentDto {

    @NotNull
    private final UUID authorId;
    @Nullable
    private final Long replyToId;
    @NotNull
    private final Long PostId;
    @NotEmpty
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
