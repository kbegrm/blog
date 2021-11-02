package com.kem.blog.dto.post;

import java.util.Date;

public class PostPreviewDto {

    private final Long id;
    private final String title;
    private final Date postDate;

    public PostPreviewDto(Long postId, String title, Date postDate) {
        this.id = postId;
        this.title = title;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getPostDate() {
        return postDate;
    }
}
