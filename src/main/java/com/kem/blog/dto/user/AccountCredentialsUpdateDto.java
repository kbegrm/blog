package com.kem.blog.dto.user;

import java.util.UUID;

public class AccountCredentialsUpdateDto {

    private final UUID userid;
    private final String update;

    public AccountCredentialsUpdateDto(UUID userid, String update) {
        this.userid = userid;
        this.update = update;
    }

    public UUID getUserid() {
        return userid;
    }

    public String getUpdate() {
        return update;
    }
}
