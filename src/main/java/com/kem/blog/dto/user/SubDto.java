package com.kem.blog.dto.user;

import java.util.UUID;

public class SubDto {

    private final UUID userId;
    private final Long topicId;

    public SubDto(UUID userId, Long topicId) {
        this.userId = userId;
        this.topicId = topicId;
    }

    public UUID getUserId() {
        return userId;
    }

    public Long getTopicId() {
        return topicId;
    }
}
