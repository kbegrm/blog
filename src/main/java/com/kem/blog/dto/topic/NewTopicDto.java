package com.kem.blog.dto.topic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class NewTopicDto {

    @NotBlank
    private final String title;
    @NotBlank
    private final String description;

    public NewTopicDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
