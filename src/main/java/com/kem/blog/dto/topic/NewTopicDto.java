package com.kem.blog.dto.topic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class NewTopicDto {

    @NotNull
    private final UUID authorId;
    @NotBlank
    private final String title;
    @NotBlank
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
