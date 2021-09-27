package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.UserDto;
import com.kem.blog.dto.user.UserPreviewDto;
import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    UserDto getById(UUID id) {
        User user = userRepo.getById(id);
        return Mapper.userToDto(user);
    }

    Collection<UserPreviewDto> getByUsername(String username) {
        return userRepo.findByUsername(username)
                .stream().map(Mapper::userToPreviewDto)
                .collect(Collectors.toSet());
    }
}
