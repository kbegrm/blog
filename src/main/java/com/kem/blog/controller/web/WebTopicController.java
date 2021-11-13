package com.kem.blog.controller.web;

import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicUpdateDto;
import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/web/topic")
@Validated
public class WebTopicController {

    private TopicService topicService;

    @Autowired
    public WebTopicController(TopicService topicService) {
        this.topicService = topicService;
    }




    @GetMapping("/create")
    public String create() {
        return "CreateTopic";
    }

    @PostMapping("/create")
    public void create(@Valid NewTopicDto dto,
                       @AuthenticationPrincipal SecurityUserDetails principal) {
        topicService.create(dto, principal);
    }

    @GetMapping
    public String get(@RequestParam @NotNull Long id, Model model) {
        TopicDto topic = topicService.get(id);
        model.addAttribute("posts", topic.getPosts());
        model.addAttribute("creator", topic.getCreator());
        model.addAttribute("creationDate", topic.getCreationDate());
        model.addAttribute("description", topic.getDescription());
        model.addAttribute("pageTitle", topic.getTitle());
        model.addAttribute("header", topic.getTitle());
        model.addAttribute("description", topic.getDescription());
        return "Posts";
    }

    @GetMapping("/update")
    public String updateDescription(@NotNull @RequestParam Long id) {
        return "UpdateTopic";
    }

    @PutMapping("/update")
    public void updateDescription(@Valid TopicUpdateDto dto,
                                  @AuthenticationPrincipal SecurityUserDetails principal) {
        topicService.updateDescription(dto);
    }
}
