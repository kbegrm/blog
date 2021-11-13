package com.kem.blog.controller;

import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicUpdateDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;

@RestController
@RequestMapping("/topic")
@Validated
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }



    @PostMapping
    public void create(@Valid @RequestBody NewTopicDto dto,
                       @AuthenticationPrincipal SecurityUserDetails user) {
        topicService.create(dto, user);
    }

    @GetMapping
    public TopicDto get(@NotNull @RequestBody Long topicId) {
        return topicService.get(topicId);
    }

    @PutMapping
    public void updateDescription(@Valid @RequestBody TopicUpdateDto dto) {
        topicService.updateDescription(dto);
    }
}
