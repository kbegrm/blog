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

    @Autowired
    public PostService(PostRepo postRepo, UserRepo userRepo, TopicRepo topicRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
    }



    public void create(NewPostDto dto) {
        Post post = Mapper.dtoToPost(dto);
        postRepo.save(post);
    }

    public PostDto get(Long id) {
        Post post = postRepo.getById(id);
        return Mapper.postToDto(post);
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
