package com.kem.blog.dto.user.Account;

import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.topic.TopicPreviewDto;
import com.kem.blog.dto.user.UserDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AccountDto extends UserDto {

    private final String email;
    private final Boolean enabled;
    private final List<TopicPreviewDto> subscriptions;

    public AccountDto(UUID id, String username, Date registerDate,
                      List<TopicPreviewDto> topics, List<PostPreviewDto> posts,
                      String email, Boolean enabled, List<TopicPreviewDto> subscriptions) {
        super(id, username, registerDate, topics, posts);
        this.email = email;
        this.enabled = enabled;
        this.subscriptions = subscriptions;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public List<TopicPreviewDto> getSubscriptions() {
        return subscriptions;
    }

}
