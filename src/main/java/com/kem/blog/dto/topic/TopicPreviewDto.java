package com.kem.blog.dto.topic;

public class TopicPreviewDto {

    private final Long id;
    private final String title;

    public TopicPreviewDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
