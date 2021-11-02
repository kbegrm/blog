package com.kem.blog.dto.user;

import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.topic.TopicPreviewDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class UserDto extends UserPreviewDto {

    private final Date registerDate;
    private final List<TopicPreviewDto> topics;
    private final List<PostPreviewDto> posts;

    public UserDto(UUID id, String username, Date registerDate,
                   List<TopicPreviewDto> topics, List<PostPreviewDto> posts) {
        super(id, username);
        this.registerDate = registerDate;
        this.topics = topics;
        this.posts = posts;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public List<TopicPreviewDto> getTopics() {
        return topics;
    }

    public List<PostPreviewDto> getPosts() {
        return posts;
    }
}
