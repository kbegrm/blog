package com.kem.blog.service;

import com.kem.blog.dto.TopicDto;
import com.kem.blog.model.Topic;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TopicService {

    private TopicRepo topicRepo;
    private UserRepo userRepo;

    public TopicService(TopicRepo topicRepo, UserRepo userRepo) {
        this.topicRepo = topicRepo;
        this.userRepo = userRepo;
    }


    void create(TopicDto dto) {
        Topic topic = new Topic(
                dto.getTitle(),
                dto.getDescription(),
                userRepo.getById(dto.getAuthorId())
        );
        topicRepo.save(topic);
    }

    void updateDescription(TopicDto dto) {
        Topic topic = topicRepo.getById(dto.getTopicId());
        topic.setDescription(dto.getDescription());
    }

    // TODO sub unsub
}
