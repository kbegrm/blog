package com.kem.blog.repository;

import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TopicRepo  extends JpaRepository<Topic, Long> {

    Set<Topic> getByCreator(User creator);
}
