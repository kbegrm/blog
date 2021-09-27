package com.kem.blog.dto.user;

import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.topic.TopicPreviewDto;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class AccountDto {

    private final UUID userId;
    private final String username;
    private final String email;
    private final Date registerDate;
    private final Boolean enabled;
    private final Set<TopicPreviewDto> createdTopics;
    private final Set<TopicPreviewDto> subscriptions;
    private final Set<PostPreviewDto> createdPosts;

    public AccountDto(UUID userId, String username, String email,
                      Date registerDate, Boolean enabled,
                      Set<TopicPreviewDto> createdTopics,
                      Set<TopicPreviewDto> subscriptions,
                      Set<PostPreviewDto> createdPosts) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.registerDate = registerDate;
        this.enabled = enabled;
        this.createdTopics = createdTopics;
        this.subscriptions = subscriptions;
        this.createdPosts = createdPosts;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Set<TopicPreviewDto> getCreatedTopics() {
        return createdTopics;
    }

    public Set<TopicPreviewDto> getSubscriptions() {
        return subscriptions;
    }

    public Set<PostPreviewDto> getCreatedPosts() {
        return createdPosts;
    }
}
