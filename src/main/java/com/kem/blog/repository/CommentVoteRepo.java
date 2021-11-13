package com.kem.blog.repository;

import com.kem.blog.model.Comment;
import com.kem.blog.model.User;
import com.kem.blog.model.Vote.CommentVote;
import com.kem.blog.model.Vote.CommentVoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentVoteRepo extends JpaRepository<CommentVote , Long> {

    Optional<CommentVote> findByUserAndComment(User voter, Comment comment);   // TODO test
}
