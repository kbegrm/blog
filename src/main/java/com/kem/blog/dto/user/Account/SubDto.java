package com.kem.blog.dto.user.Account;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class SubDto {

    @NotNull
    private final UUID userId;
    @NotNull
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
