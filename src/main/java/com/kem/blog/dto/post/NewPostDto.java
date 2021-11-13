package com.kem.blog.dto.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class NewPostDto {

    @NotNull
    private final Long topicId;
    @NotBlank
    private final String title;
    @NotBlank
    private final String text;

    public NewPostDto(Long topicId, String title, String text) {
        this.topicId = topicId;
        this.title = title;
        this.text = text;
    }


    public Long getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
