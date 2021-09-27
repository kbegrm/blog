package com.kem.blog.dto.topic;

public class TopicPreviewDto {

    private final Long topicId;
    private final String title;

    public TopicPreviewDto(Long topicId, String title) {
        this.topicId = topicId;
        this.title = title;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }
}
