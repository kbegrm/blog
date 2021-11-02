package com.kem.blog.dto.topic;

import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.user.UserPreviewDto;

import java.util.Date;
import java.util.List;

public class TopicDto extends TopicPreviewDto{

    private final String description;
    private final Date creationDate;
    private final UserPreviewDto creator;
    private final List<PostPreviewDto> posts;

    public TopicDto(Long topicId, String title, String description,
                    Date creationDate, UserPreviewDto creator, List<PostPreviewDto> posts) {
        super(topicId, title);
        this.description = description;
        this.creationDate = creationDate;
        this.creator = creator;
        this.posts = posts;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UserPreviewDto getCreator() {
        return creator;
    }

    public List<PostPreviewDto> getPosts() {
        return posts;
    }
}
