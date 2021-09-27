package com.kem.blog.dto.topic;

import java.util.UUID;

public class NewTopicDto {

    private final UUID authorId;
    private final String title;
    private final String description;

    public NewTopicDto(UUID authorId, String title, String description) {
        this.authorId = authorId;
        this.title = title;
        this.description = description;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
