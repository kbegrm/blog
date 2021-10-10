package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.RegisterDto;
import com.kem.blog.dto.user.AccountCredentialsUpdateDto;
import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AccountDetailsService {

    private UserRepo userRepo;

    @Autowired
    public AccountDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



     public void register(RegisterDto dto) {
        User newUser = Mapper.AccCredToUser(dto);
        newUser.setEnabled(true);       // TODO активация после подтверждения почты; проверка надежности пороля
        userRepo.save(newUser);
    }

//    SomeToken signIn(AccountDto dto){      // TODO вход в аккаунт. ссессия или токен
//
//    }

    public void changeUsername(AccountCredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        user.setUsername(dto.getUpdate());
    }

    public void changePassword(AccountCredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        String newPassword = dto.getUpdate();
        // TODO проверка пороля на соответствие условиям безопасности
        user.setPassword(newPassword);
    }

    public void changeEmail(AccountCredentialsUpdateDto dto) {
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
