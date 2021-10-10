package com.kem.blog.repository;

import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TopicRepo  extends JpaRepository<Topic, Long> {

    Set<Topic> getByCreator(User creator);
}
