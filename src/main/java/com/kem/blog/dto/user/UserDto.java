package com.kem.blog.dto.user;

import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.topic.TopicPreviewDto;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class UserDto {

    private final UUID userId;
    private final String username;
    private final Date registerDate;
    private final Set<TopicPreviewDto> topics;
    private final Set<PostPreviewDto> posts;

    public UserDto(UUID userId, String username, Date registerDate,
                   Set<TopicPreviewDto> topics, Set<PostPreviewDto> posts) {
        this.userId = userId;
        this.username = username;
        this.registerDate = registerDate;
        this.topics = topics;
        this.posts = posts;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Set<TopicPreviewDto> getTopics() {
        return topics;
    }

    public Set<PostPreviewDto> getPosts() {
        return posts;
    }
}
