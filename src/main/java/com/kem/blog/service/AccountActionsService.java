package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.AccountDto;
import com.kem.blog.dto.user.FollowDto;
import com.kem.blog.dto.user.SubDto;
import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AccountActionsService {

    private UserRepo userRepo;
    private TopicRepo topicRepo;


    public AccountActionsService(UserRepo userRepo, TopicRepo topicRepo) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
    }



    AccountDto getAccountInfo(UUID userId) {
        User user = userRepo.getById(userId);
        return Mapper.userToAccountDto(user);
    }

    void subscribe(SubDto dto){
        User user = userRepo.getById(dto.getUserId());
        Topic topic = topicRepo.getById(dto.getTopicId());
        user.getSubscriptions().add(topic);
    }

    void unsubscribe(SubDto dto){
        User user = userRepo.getById(dto.getUserId());
        Topic topic = topicRepo.getById(dto.getTopicId());
        user.getSubscriptions().remove(topic);
    }

    void follow(FollowDto dto){
        User user = userRepo.getById(dto.getUserId());
        User toBeFollowed = userRepo.getById(dto.getOtherUserId());
        user.getFollowed().add(toBeFollowed);
    }

    void unfollow(FollowDto dto){
        User user = userRepo.getById(dto.getUserId());
        User toBeUnfollowed = userRepo.getById(dto.getOtherUserId());
        user.getFollowed().remove(toBeUnfollowed);
    }
}