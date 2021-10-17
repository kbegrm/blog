package com.kem.blog.dto;

import com.kem.blog.dto.comment.CommentDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicPreviewDto;
import com.kem.blog.dto.user.RegisterDto;
import com.kem.blog.dto.user.AccountDto;
import com.kem.blog.dto.user.UserDto;
import com.kem.blog.dto.user.UserPreviewDto;
import com.kem.blog.model.Comment;
import com.kem.blog.model.Post;
import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import com.kem.blog.model.Vote.VoteType;
import com.kem.blog.repository.CommentRepo;
import com.kem.blog.repository.PostRepo;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
public class Mapper {

    private static UserRepo userRepo;
    private static TopicRepo topicRepo;
    private static PostRepo postRepo;
    private static CommentRepo commentRepo;

    // ---USER---
    public static UserDto userToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getRegisterDate(),
                topicsToPreviewDto(user.getCreatedTopics()),
                postsToPreviewDto(user.getPosts())
        );
    }

    public static UserPreviewDto userToPreviewDto(User user) {
        return new UserPreviewDto(user.getId(), user.getUsername());
    }

    public static AccountDto userToAccountDto(User user) {
        return new AccountDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRegisterDate(),
                user.getEnabled(),
                topicsToPreviewDto(user.getCreatedTopics()),
                topicsToPreviewDto(user.getSubscriptions()),
                postsToPreviewDto(user.getPosts())
        );
    }

    public static User AccCredToUser(RegisterDto dto) {
        return new User(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );
    }



    // ---TOPIC---
    public static TopicDto topicToDto(Topic topic) {
        return new TopicDto(
                userToPreviewDto(topic.getCreator()),
                topic.getId(),
                topic.getTitle(),
                topic.getDescription(),
                postsToPreviewDto(topic.getPosts())
        );
    }

    public static TopicDto topicToDtoLimitPosts(Topic topic) {
        return new TopicDto(
                userToPreviewDto(topic.getCreator()),
                topic.getId(),
                topic.getTitle(),
                topic.getDescription(),
                postsToPreviewDto(postRepo.findFirst10ByTopicOrderByDateDesc(topic))
        );
    }

    public static TopicPreviewDto topicToPreviewDto(Topic topic) {
        return new TopicPreviewDto(topic.getId(), topic.getTitle());
    }

    public static Set<TopicPreviewDto> topicsToPreviewDto(Collection<Topic> topics) {
        return topics.stream().map(Mapper::topicToPreviewDto).collect(Collectors.toSet());
    }

    public static Topic dtoToTopic(NewTopicDto dto) {
        return new Topic(
                dto.getTitle(),
                dto.getDescription(),
                userRepo.getById(dto.getAuthorId())
        );
    }



    // ---POST---
    public static PostPreviewDto postToPreviewDto(Post post) {
        return new PostPreviewDto(post.getId(), post.getTitle());
    }

    public static Set<PostPreviewDto> postsToPreviewDto(Collection<Post> posts) {
        return posts.stream().map(Mapper::postToPreviewDto).collect(Collectors.toSet());
    }

    public static PostDto postToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getText(),
                post.getPostDate(),
                userToPreviewDto(post.getAuthor()),
                topicToPreviewDto(post.getTopic()),
                commentsToDto(post.getComments()),
                post.getVotes().stream().filter(p -> p.getVote() == VoteType.UPVOTE).count(),
                post.getVotes().stream().filter(p -> p.getVote() == VoteType.DOWNVOTE).count()
        );
    }

    public static Post dtoToPost(NewPostDto dto) {
        return new Post(
                dto.getTitle(),
                dto.getText(),
                userRepo.getById(dto.getAuthorId()),
                topicRepo.getById(dto.getTopicId())
        );
    }



    // ---COMMENT---
    public static CommentDto commentToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getText(),
                comment.getPostDate(),
                comment.getReplyTo().getId(),
                userToPreviewDto(comment.getAuthor()),
                comment.getVotes().stream().filter(v -> v.getVote() == VoteType.UPVOTE).count(),
                comment.getVotes().stream().filter(v -> v.getVote() == VoteType.DOWNVOTE).count()
        );
    }


    public static Comment dtoToComment(NewCommentDto dto) {
        return new Comment(
                dto.getText(),
                userRepo.getById(dto.getAuthorId()),
                postRepo.getById(dto.getPostId()),
                commentRepo.getById(dto.getReplyToId())
        );
    }


    public static Set<CommentDto> commentsToDto(Collection<Comment> comments) {
        return comments.stream().map(Mapper::commentToDto).collect(Collectors.toSet());
    }




//    // ---COMMENT EXTRAS---

//    public static Set<CommentGraphDto> commentsToDtoGraph(Set<Comment> comments) {
//        Set<Comment> originalComments = comments.stream()
//                .filter(c -> c.getReplyTo().equals(null))
//                .collect(Collectors.toSet());
//        return setReplies(originalComments);
//    }
//
//    private static Set<CommentGraphDto> setReplies(Set<Comment> comments) {
//        return comments.stream().map(c -> new CommentGraphDto(
//                c.getId(), c.getText(), c.getPostDate(),
//                userToPreviewDto(c.getAuthor()),
//                setReplies(c.getReplies()),
//                c.getVotes().stream().filter(v -> v.getVote() == VoteType.UPVOTE).count(),
//                c.getVotes().stream().filter(v -> v.getVote() == VoteType.DOWNVOTE).count()
//        )).collect(Collectors.toSet());
//    }
//
//    static class CommentGraphDto {
//
//        private final Long commentId;
//        private final String text;
//        private final Date postDate;
//        private final UserPreviewDto author;
//        private final Set<CommentGraphDto> replies;
//        private final Long upvotes;
//        private final Long downvotes;
//
//        public CommentGraphDto(Long commentId, String text, Date postDate, UserPreviewDto author,
//                               Set<CommentGraphDto> replies, Long upvotes, Long downvotes) {
//            this.commentId = commentId;
//            this.text = text;
//            this.postDate = postDate;
//            this.author = author;
//            this.replies = replies;
//            this.upvotes = upvotes;
//            this.downvotes = downvotes;
//        }
//
//        public Long getCommentId() {
//            return commentId;
//        }
//
//        public String getText() {
//            return text;
//        }
//
//        public Date getPostDate() {
//            return postDate;
//        }
//
//        public UserPreviewDto getAuthor() {
//            return author;
//        }
//
//        public Set<CommentGraphDto> getReplies() {
//            return replies;
//        }
//
//        public Long getUpvotes() {
//            return upvotes;
//        }
//
//        public Long getDownvotes() {
//            return downvotes;
//        }
//    }
}
