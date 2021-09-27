package com.kem.blog.dto.user;

import java.util.UUID;

public class FollowDto {

    private final UUID userId;
    private final UUID otherUserId;   // на кого оформляется / отменяется подписка

    public FollowDto(UUID user, UUID otherUser) {
        this.userId = user;
        this.otherUserId = otherUser;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getOtherUserId() {
        return otherUserId;
    }
}
