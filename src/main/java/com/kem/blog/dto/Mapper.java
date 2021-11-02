package com.kem.blog.dto;

import com.kem.blog.dto.comment.CommentDto;
import com.kem.blog.dto.comment.NewCommentDto;
import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicPreviewDto;
import com.kem.blog.dto.user.Account.AccountDto;
import com.kem.blog.dto.user.Credentials.RegisterDto;
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
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class Mapper {

    private UserRepo userRepo;
    private TopicRepo topicRepo;
    private PostRepo postRepo;
    private CommentRepo commentRepo;

    public Mapper(UserRepo userRepo, TopicRepo topicRepo, PostRepo postRepo, CommentRepo commentRepo) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }



    // ---USER---
    public UserDto userToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getRegisterDate(),
                topicsToPreviewDto(user.getCreatedTopics()),
                postsToPreviewDto(user.getPosts())
        );
    }

    public UserPreviewDto userToPreviewDto(User user) {
        return new UserPreviewDto(user.getId(), user.getUsername());
    }

    public AccountDto userToAccountDto(User user) {
        return new AccountDto(
                user.getId(),
                user.getUsername(),
                user.getRegisterDate(),
                topicsToPreviewDto(user.getCreatedTopics()),
                postsToPreviewDto(user.getPosts()),
                user.getEmail(),
                user.getEnabled(),
                topicsToPreviewDto(user.getSubscriptions())
        );
    }

    public User RegisterDtoToUser(RegisterDto dto) {
        return new User(
                dto.getUsername(),
                dto.getPassword(),
                dto.getEmail()
        );
    }



    // ---TOPIC---
    public TopicDto topicToDto(Topic topic) {
        return new TopicDto(
                topic.getId(),
                topic.getTitle(),
                topic.getDescription(),
                topic.getCreationDate(),
                userToPreviewDto(topic.getCreator()),
                postsToPreviewDto(topic.getPosts())
        );
    }

    public TopicDto topicToDtoLimitPosts(Topic topic) {
        return new TopicDto(
                topic.getId(),
                topic.getTitle(),
                topic.getDescription(),
                topic.getCreationDate(),
                userToPreviewDto(topic.getCreator()),
                postsToPreviewDto(postRepo.findFirst10ByTopicOrderByPostDateDesc(topic))
        );
    }

    public TopicPreviewDto topicToPreviewDto(Topic topic) {
        return new TopicPreviewDto(topic.getId(), topic.getTitle());
    }

    public List<TopicPreviewDto> topicsToPreviewDto(Collection<Topic> topics) {
        return topics.stream().map(this::topicToPreviewDto).collect(Collectors.toList());
    }

    public Topic dtoToTopic(NewTopicDto dto) {
        return new Topic(
                dto.getTitle(),
                dto.getDescription(),
                userRepo.getById(dto.getAuthorId())
        );
    }



    // ---POST---
    public PostPreviewDto postToPreviewDto(Post post) {
        return new PostPreviewDto(post.getId(), post.getTitle(), post.getPostDate());
    }

    public List<PostPreviewDto> postsToPreviewDto(Collection<Post> posts) {
        return posts.stream().map(this::postToPreviewDto).collect(Collectors.toList());
    }

    public PostDto postToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getPostDate(),
                post.getText(),
                userToPreviewDto(post.getAuthor()),
                topicToPreviewDto(post.getTopic()),
                commentsToDto(post.getComments()),
                post.getVotes().stream().filter(p -> p.getVote() == VoteType.UPVOTE).count(),
                post.getVotes().stream().filter(p -> p.getVote() == VoteType.DOWNVOTE).count()
        );
    }

    public Post dtoToPost(NewPostDto dto) {
        return new Post(
                dto.getTitle(),
                dto.getText(),
                userRepo.getById(dto.getAuthorId()),
                topicRepo.getById(dto.getTopicId())
        );
    }



    // ---COMMENT---
    public List<CommentDto> commentsToDto(Collection<Comment> comments) {
        List<Comment> originalComments = comments.stream()
                .filter(c -> c.getReplyTo().equals(null))
                .sorted((c1, c2) -> (int) (c1.getPostDate().getTime() - c2.getPostDate().getTime()))
                .collect(Collectors.toList());
        return setReplies(originalComments);
    }

    private List<CommentDto> setReplies(Collection<Comment> comments) {
        return comments.stream()
                .sorted((c1, c2) -> (int) (c1.getPostDate().getTime() - c2.getPostDate().getTime()))
                .map(c -> new CommentDto(
                    c.getId(), c.getText(), c.getPostDate(),
                    userToPreviewDto(c.getAuthor()),
                    setReplies(c.getReplies()),
                    c.getVotes().stream().filter(v -> v.getVote() == VoteType.UPVOTE).count(),
                    c.getVotes().stream().filter(v -> v.getVote() == VoteType.DOWNVOTE).count()
        )).collect(Collectors.toList());
    }

    public Comment dtoToComment(NewCommentDto dto) {
        return new Comment(
                dto.getText(),
                userRepo.getById(dto.getAuthorId()),
                postRepo.getById(dto.getPostId()),
                dto.getReplyToId() == null ? null : commentRepo.getById(dto.getReplyToId())
        );
    }
}
