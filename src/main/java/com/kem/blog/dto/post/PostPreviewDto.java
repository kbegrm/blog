package com.kem.blog.dto.post;

public class PostPreviewDto {
    private final Long postId;
    private final String title;

    public PostPreviewDto(Long postId, String title) {
        this.postId = postId;
        this.title = title;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }
}
