package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.user.AccountCredentialsDto;
import com.kem.blog.dto.user.AccountCredentialsUpdateDto;
import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountDetailsService {

    private UserRepo userRepo;

    public AccountDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    void register(AccountCredentialsDto dto) {
        User newUser = Mapper.AccCredToUser(dto);
        newUser.setEnabled(true);       // TODO активация после подтверждения почты; проверка надежности пороля
        userRepo.save(newUser);
    }

//    SomeToken signIn(AccountDto dto){      // TODO вход в аккаунт. ссессия или токен
//
//    }

    void changeUsername(AccountCredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        user.setUsername(dto.getUpdate());
    }

    void changePassword(AccountCredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        String newPassword = dto.getUpdate();
        // TODO проверка пороля на соответствие условиям безопасности
        user.setPassword(newPassword);
    }

    void changeEmail(AccountCredentialsUpdateDto dto) {
        User user = userRepo.getById(dto.getUserid());
        // TODO подтверждение почты
        user.setEmail(dto.getUpdate());
    }

    void enable(AccountCredentialsDto dto) {
        userRepo.getById(dto.getId()).setEnabled(true);
    }

    void disable(AccountCredentialsDto dto) {
        userRepo.getById(dto.getId()).setEnabled(false);
    }
}
