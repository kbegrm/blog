package com.kem.blog.dto.post;

import java.util.UUID;

public class NewPostDto {

    private final UUID authorId;
    private final Long topicId;
    private final String title;
    private final String text;

    public NewPostDto(UUID authorId, Long topicId, String title, String text) {
        this.authorId = authorId;
        this.topicId = topicId;
        this.title = title;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
