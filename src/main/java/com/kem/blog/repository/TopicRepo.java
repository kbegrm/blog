package com.kem.blog.repository;

import com.kem.blog.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo  extends JpaRepository<Topic, Long> {
}
