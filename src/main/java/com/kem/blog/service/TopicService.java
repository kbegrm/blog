package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicUpdateDto;
import com.kem.blog.model.Topic;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TopicService {

    private TopicRepo topicRepo;
    private UserRepo userRepo;
    private Mapper mapper;

//    private final int NUMBER_OF_POSTS = 10;

    @Autowired
    public TopicService(TopicRepo topicRepo, UserRepo userRepo, Mapper mapper) {
        this.topicRepo = topicRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }



    public void create(NewTopicDto dto) {
        Topic topic = mapper.dtoToTopic(dto);
        topicRepo.save(topic);
    }

//    TODO
//    public TopicDto get(Long id) {
//        return get(id, NUMBER_OF_POSTS);
//    }

//    public TopicDto get(Long id, int numberOfPostsToFetch) {
//        Topic topic = topicRepo.getById(id);
//        ...
//    }

    public  TopicDto get(Long id) {
        Topic topic = topicRepo.getById(id);
        return mapper.topicToDtoLimitPosts(topic);
    }

    public TopicDto getFull(Long id) {
        Topic topic = topicRepo.getById(id);
        return mapper.topicToDto(topic);
    }

    public void updateDescription(TopicUpdateDto dto) {
        Topic topic = topicRepo.getById(dto.getId());
        topic.setDescription(dto.getUpdate());
    }
}
