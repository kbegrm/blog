package com.kem.blog.dto.user.Credentials;

import com.kem.blog.validation.EmailUpdate;
import com.kem.blog.validation.PasswordUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CredentialsUpdateDto {

    @NotNull
    private final UUID userid;
    @NotBlank
    @Length(min = 8, groups = PasswordUpdate.class)
    @Email(groups =  EmailUpdate.class)
    private final String update;

    public CredentialsUpdateDto(UUID userid, String update) {
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
