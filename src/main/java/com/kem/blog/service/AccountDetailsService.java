package com.kem.blog.service;

import com.kem.blog.dto.AccountDto;
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



    void register(AccountDto dto) {
        User newUser = new User(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );
        newUser.setEnabled(true);       // TODO активация после подтверждения почты; проверка надежности пороля
        userRepo.save(newUser);
    }

//    SomeToken signIn(AccountDto dto){      // TODO вход в аккаунт. ссессия или токен
//
//    }

    void changeUsername(AccountDto dto) {
        User user = userRepo.getById(dto.getId());
        user.setUsername(dto.getUsername());
    }

    void changePassword(AccountDto dto) {
        User user = userRepo.getById(dto.getId());
        String newPassword = dto.getPassword();
        // TODO проверка пороля на соответствие условиям безопасности
        user.setPassword(newPassword);
    }

    void changeEmail(AccountDto dto) {
        User user = userRepo.getById(dto.getId());
        // TODO подтверждение почты
        user.setEmail(dto.getEmail());
    }

    void delete(AccountDto dto) {
        userRepo.deleteById(dto.getId());
    }

    void enable(AccountDto dto) {
        userRepo.getById(dto.getId()).setEnabled(true);
    }

    void disable(AccountDto dto) {
        userRepo.getById(dto.getId()).setEnabled(false);
    }
}
