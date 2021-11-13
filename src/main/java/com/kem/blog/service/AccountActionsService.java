package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.Account.AccountDto;
import com.kem.blog.dto.user.Account.FollowDto;
import com.kem.blog.dto.user.Account.SubDto;
import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountActionsService {

    private UserRepo userRepo;
    private TopicRepo topicRepo;
    private Mapper mapper;


    @Autowired
    public AccountActionsService(UserRepo userRepo, TopicRepo topicRepo, Mapper mapper) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.mapper = mapper;
    }



    public AccountDto getAccountInfo(UUID userId) {
        User user = userRepo.getById(userId);
        return mapper.userToAccountDto(user);
    }

    public void subscribe(Long topicId, User user){
        Topic topic = topicRepo.getById(topicId);
        user.getSubscriptions().add(topic);
    }

    public void unsubscribe(Long topicId, User user){
        Topic topic = topicRepo.getById(topicId);
        user.getSubscriptions().remove(topic);
    }

    public void follow(UUID followedId, User user){
        User toBeFollowed = userRepo.getById(followedId);
        user.getFollowed().add(toBeFollowed);
    }

    public void unfollow(UUID followedId, User user){
        User toBeUnfollowed = userRepo.getById(followedId);
        user.getFollowed().remove(toBeUnfollowed);
    }

    // TODO delete folow/sub dtos
    // TODO remove
    public List<UUID> getAllIds() {
        return userRepo.findAll().stream().map(User::getId).collect(Collectors.toList());
    }
}
