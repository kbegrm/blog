package com.kem.blog.repository;

import com.kem.blog.model.Post;
import com.kem.blog.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findFirst10ByTopicOrderByPostDateDesc(Topic topic);

    List<Post> findByPostDateAfter(Date timeSpan);

    // TODO
    // select * from post where topic = ... order by date desc limit n
    // List<Post> findFirst10ByPostDateAfterOrderByVotes
}
