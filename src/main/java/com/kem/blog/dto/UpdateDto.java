package com.kem.blog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateDto {
    // TODO remove other update dtos

    @NotNull
    private final Long id;
    @NotBlank
    private final String update;

    public UpdateDto(Long id, String update) {
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
