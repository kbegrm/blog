package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.UserDto;
import com.kem.blog.dto.user.UserPreviewDto;
import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;
    private Mapper mapper;


    @Autowired
    public UserService(UserRepo userRepo, Mapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }



    public UserDto getById(UUID id) {
        User user = userRepo.getById(id);
        return mapper.userToDto(user);
    }

    public Collection<UserPreviewDto> getByUsername(String username) {
        return userRepo.findByUsername(username)
                .stream().map(mapper::userToPreviewDto)
                .collect(Collectors.toSet());
    }
}
