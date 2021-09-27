package com.kem.blog.dto.topic;

import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Set;

public class TopicDto {

    private final UserPreviewDto author;
    private final Long topicId;
    private final String title;
    private final String description;
    private final Set<PostPreviewDto> posts;

    public TopicDto(UserPreviewDto author, Long topicId, String title,
                    String description, Set<PostPreviewDto> posts) {
        this.author = author;
        this.topicId = topicId;
        this.title = title;
        this.description = description;
        this.posts = posts;
    }

    public UserPreviewDto getAuthorId() {
        return author;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<PostPreviewDto> getPosts() {
        return posts;
    }
}
