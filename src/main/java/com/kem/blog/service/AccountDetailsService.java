package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.Credentials.RegisterDto;
import com.kem.blog.dto.user.Credentials.CredentialsUpdateDto;
import com.kem.blog.model.Role;
import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AccountDetailsService {

    private UserRepo userRepo;
    private Mapper mapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountDetailsService(UserRepo userRepo, Mapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }



     public void register(RegisterDto dto) {
        User newUser = mapper.RegisterDtoToUser(dto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRole(Role.USER);
        newUser.setEnabled(true);       // TODO активация после подтверждения почты; проверка надежности пороля
        userRepo.save(newUser);
    }

    public void changeUsername(CredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        user.setUsername(dto.getUpdate());
    }

    public void changePassword(CredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        String newPassword = dto.getUpdate();
        // TODO проверка пороля на соответствие условиям безопасности
        user.setPassword(newPassword);
    }

    public void changeEmail(CredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        // TODO подтверждение почты
        user.setEmail(dto.getUpdate());
    }

    public void enable(UUID userId) {
        userRepo.getById(userId).setEnabled(true);
    }

    public void disable(UUID userId) {
        userRepo.getById(userId).setEnabled(false);
    }
}
