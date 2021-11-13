package com.kem.blog.dto;

import com.kem.blog.model.Vote.VoteType;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class VoteDto {

    @NotNull
    private final Long targetId;
    @NotNull
    private final VoteType type;

    public VoteDto(Long targetId, VoteType type) {
        this.targetId = targetId;
        this.type = type;
    }


    public Long getTargetId() {
        return targetId;
    }

    public VoteType getType() {
        return type;
    }
}
