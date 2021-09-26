package com.kem.blog.repository;

import com.kem.blog.model.Vote.PostVote;
import com.kem.blog.model.Vote.PostVoteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostVoteRepo extends JpaRepository<PostVote, PostVoteId> {
}
