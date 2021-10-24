package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostUpdateDto;
import com.kem.blog.model.Post;
import com.kem.blog.repository.PostRepo;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostService {

    private PostRepo postRepo;
    private UserRepo userRepo;
    private TopicRepo topicRepo;
    private Mapper mapper;


    @Autowired
    public PostService(PostRepo postRepo, UserRepo userRepo, TopicRepo topicRepo, Mapper mapper) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.mapper = mapper;
    }



    public void create(NewPostDto dto) {
        Post post = mapper.dtoToPost(dto);
        postRepo.save(post);
    }

    public PostDto get(Long id) {
        Post post = postRepo.getById(id);
        return mapper.postToDto(post);
    }

    public void updateTitle(PostUpdateDto dto) {
        Post post = postRepo.getById(dto.getPostId());
        post.setTitle(dto.getUpdate());
    }

    public void updateText(PostUpdateDto dto) {
        Post post = postRepo.getById(dto.getPostId());
        post.setText(dto.getUpdate());
    }

    public void deletePost(Long id) {
        Post post = postRepo.getById(id);
        post.setTitle("[deleted]");
        post.setText("[deleted]");
    }
}
