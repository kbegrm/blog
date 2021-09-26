package com.kem.blog.repository;

import com.kem.blog.model.Vote.CommentVote;
import com.kem.blog.model.Vote.CommentVoteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentVoteRepo extends JpaRepository<CommentVote , CommentVoteId> {
}
