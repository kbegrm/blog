package com.kem.blog.dto.topic;

public class TopicUpdateDto {

    private final Long id;
    private final String update;

    public TopicUpdateDto(Long id, String update) {
        this.id = id;
        this.update = update;
    }

    public Long getId() {
        return id;
    }

    public String getUpdate() {
        return update;
    }
}
