package com.kem.blog.dto;

import java.util.UUID;

public class TopicDto {

    private final UUID authorId;
    private final Long topicId;
    private final String title;
    private final String description;

    public TopicDto(UUID authorId, Long topicId, String title, String description) {
        this.authorId = authorId;
        this.topicId = topicId;
        this.title = title;
        this.description = description;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
