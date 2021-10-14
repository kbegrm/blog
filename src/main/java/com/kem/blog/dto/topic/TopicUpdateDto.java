package com.kem.blog.dto.topic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TopicUpdateDto {

    @NotNull
    private final Long id;
    @NotBlank
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
