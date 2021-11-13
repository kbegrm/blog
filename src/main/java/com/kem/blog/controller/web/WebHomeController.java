package com.kem.blog.controller.web;

import com.kem.blog.security.SecurityUserDetails;
import com.kem.blog.service.PostService;
import com.kem.blog.service.TopicService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class WebHomeController {

    private TopicService topicService;
    private PostService postService;

    public WebHomeController(TopicService topicService, PostService postService) {
        this.topicService = topicService;
        this.postService = postService;
    }

    @GetMapping("/topics/natOrder")
    public String getInOrderTopics(Model model) {
        model.addAttribute("topics", topicService.getInOrder());
        model.addAttribute("pageTitle", "Topics");
        model.addAttribute("header", "Topics");
        return "Topics";
    }

    @GetMapping("/topics/popular")
    public String getPopularTopics(Model model) {
        model.addAttribute("topics", topicService.getPopular());
        model.addAttribute("pageTitle", "Popular topics");
        model.addAttribute("header", "Popular topics");
        return "Topics";
    }

    @GetMapping("/topics/new")
    public String getNewTopics(Model model) {
        model.addAttribute("topics", topicService.getNew());
        model.addAttribute("pageTitle", "New topics");
        model.addAttribute("header", "New topics");
        return "Topics";
    }

    @GetMapping("/posts/new")
    public String getNewPosts(Model model) {
        model.addAttribute("posts", postService.getNew());
        return "Posts";
    }

    @GetMapping("/posts/popular")
    public String getPopular(Model model) {
        model.addAttribute("posts", postService.getPopular());
        return "Posts";
    }

    @GetMapping("/posts/subscriptions")
    public String getSubs(Model model, @AuthenticationPrincipal SecurityUserDetails userDetails) {
        model.addAttribute("posts", postService.getSubscriptions(userDetails.getUser()));
        return "Posts";
    }

    @GetMapping("/posts/followed")
    public String getPopular(Model model, @AuthenticationPrincipal SecurityUserDetails userDetails) {
        model.addAttribute("posts", postService.getFollowed(userDetails.getUser()));
        return "Posts";
    }
}
