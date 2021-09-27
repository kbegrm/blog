package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicUpdateDto;
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


    void create(NewTopicDto dto) {
        Topic topic = Mapper.dtoToTopic(dto);
        topicRepo.save(topic);
    }

    TopicDto get(Long id) {
        Topic topic = topicRepo.getById(id);
        return Mapper.topicToDto(topic);
    }

    void updateDescription(TopicUpdateDto dto) {
        Topic topic = topicRepo.getById(dto.getId());
        topic.setDescription(dto.getUpdate());
    }
}
