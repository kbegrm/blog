package com.kem.blog.security;

import com.kem.blog.model.User;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public SecurityUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "no registered users with email [" + s + "]"));
        return new SecurityUserDetails(user);
    }
}
