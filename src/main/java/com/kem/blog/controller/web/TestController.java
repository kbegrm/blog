package com.kem.blog.controller.web;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.model.Post;
import com.kem.blog.repository.PostRepo;
import com.kem.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/test")
public class TestController {

    private PostService postService;
    private PostRepo postRepo;
    private Mapper mapper;
    private final int TOP_POSTS_AMOUNT = 10;

    public TestController(PostService postService, PostRepo postRepo, Mapper mapper) {
        this.postService = postService;
        this.postRepo = postRepo;
        this.mapper = mapper;
    }


    @GetMapping("/top-posts")
    @Transactional
    public String getTopPosts(Model model) {
        List<Post> posts = postRepo.findByPostDateAfter(
                Date.from(Instant.now().minus(Duration.ofHours(24))));
        posts = posts.stream()
                .sorted(Comparator.comparing(Post::getPostDate).reversed())
                .limit(TOP_POSTS_AMOUNT).collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("pageTitle", "top posts");
        model.addAttribute("header", "top posts");
//        List<PostPreviewDto> dtos = mapper.postsToPreviewDto(posts);
//        model.addAttribute("posts", dtos);
        return "test";
    }
}
