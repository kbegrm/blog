package com.kem.blog.dto.user;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class FollowDto {

    @NotNull
    private final UUID userId;
    @NotNull
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
