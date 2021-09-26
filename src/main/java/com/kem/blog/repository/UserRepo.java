package com.kem.blog.repository;

import com.kem.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

    Set<User> findByUsername(String username);
}
