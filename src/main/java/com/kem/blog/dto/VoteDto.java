package com.kem.blog.dto;

import com.kem.blog.model.Vote.VoteType;

import java.util.UUID;

public class VoteDto {

    private final UUID voterId;
    private final Long targetId;
    private final VoteType type;

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
