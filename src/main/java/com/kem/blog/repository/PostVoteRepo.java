package com.kem.blog.repository;

import com.kem.blog.model.Post;
import com.kem.blog.model.User;
import com.kem.blog.model.Vote.PostVote;
import com.kem.blog.model.Vote.PostVoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostVoteRepo extends JpaRepository<PostVote, Long> {

    Optional<PostVote> findByVoterAndPost(User voter, Post post);
}
