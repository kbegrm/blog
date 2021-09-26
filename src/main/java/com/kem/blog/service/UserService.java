package com.kem.blog.service;

import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    User getById(UUID id) {
        return userRepo.getById(id);
    }

    Collection<User> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // TODO follow unfollow
}
