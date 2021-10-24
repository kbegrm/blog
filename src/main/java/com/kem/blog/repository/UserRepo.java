package com.kem.blog.repository;

import com.kem.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    List<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
