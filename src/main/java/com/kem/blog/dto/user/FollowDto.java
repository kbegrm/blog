package com.kem.blog.dto.user;

import java.util.UUID;

public class FollowDto {

    private final UUID userId;
    private final UUID followedUserId;

    public FollowDto(UUID user, UUID otherUser) {
        this.userId = user;
        this.followedUserId = otherUser;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getFollowedUserId() {
        return followedUserId;
    }
}
