package com.kem.blog.controller;

import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicUpdateDto;
import com.kem.blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/topic")
@Validated
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }



    @PostMapping
    public void create(@Valid NewTopicDto dto) {
        topicService.create(dto);
    }

    @GetMapping
    public TopicDto get(Long topicId) {
        return topicService.get(topicId);
    }

    @PutMapping
    public void updateDescription(@Valid TopicUpdateDto dto) {
        topicService.updateDescription(dto);
    }
}