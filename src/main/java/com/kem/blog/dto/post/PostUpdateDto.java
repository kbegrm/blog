package com.kem.blog.dto.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostUpdateDto {

    @NotNull
    private final Long postId;
    @NotBlank
    private final String update;

    public PostUpdateDto(Long postId, String text) {
        this.postId = postId;
        this.update = text;
    }

    public Long getPostId() {
        return postId;
    }

    public String getUpdate() {
        return update;
    }
}
