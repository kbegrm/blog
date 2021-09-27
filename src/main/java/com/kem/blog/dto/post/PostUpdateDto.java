package com.kem.blog.dto.post;

public class PostUpdateDto {

    private final Long postId;
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
