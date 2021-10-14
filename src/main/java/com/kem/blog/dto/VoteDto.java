package com.kem.blog.dto;

import com.kem.blog.model.Vote.VoteType;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class VoteDto {

    @NotNull
    private final UUID voterId;
    @NotNull
    private final Long targetId;
    @NotNull
    private final VoteType type;        //TODO string?

    public VoteDto(UUID userId, Long targetId, VoteType type) {
        this.voterId = userId;
        this.targetId = targetId;
        this.type = type;
    }

    public UUID getVoterId() {
        return voterId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public VoteType getType() {
        return type;
    }
}
