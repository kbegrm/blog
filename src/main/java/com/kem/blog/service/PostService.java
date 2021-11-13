package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.post.NewPostDto;
import com.kem.blog.dto.post.PostDto;
import com.kem.blog.dto.post.PostPreviewDto;
import com.kem.blog.dto.post.PostUpdateDto;
import com.kem.blog.model.Post;
import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import com.kem.blog.model.Vote.PostVote;
import com.kem.blog.model.Vote.VoteType;
import com.kem.blog.repository.PostRepo;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    private PostRepo postRepo;
    private UserRepo userRepo;
    private TopicRepo topicRepo;
    private Mapper mapper;


    @Autowired
    public PostService(PostRepo postRepo, UserRepo userRepo, TopicRepo topicRepo, Mapper mapper) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.mapper = mapper;
    }


    public void create(NewPostDto dto, User author) {
        Post post = mapper.dtoToPost(dto, author);
        postRepo.save(post);
    }

    public PostDto get(Long id) {
        Post post = postRepo.getById(id);
        return mapper.postToDto(post);
    }

    public void updateTitle(PostUpdateDto dto) {
        Post post = postRepo.getById(dto.getPostId());
        post.setTitle(dto.getUpdate());
    }

    public void updateText(PostUpdateDto dto) {
        Post post = postRepo.getById(dto.getPostId());
        post.setText(dto.getUpdate());
    }

    public void deletePost(Long id) {
        Post post = postRepo.getById(id);
        post.setTitle("[deleted]");
        post.setText("[deleted]");
    }


    // TODO filter in DB

    public List<PostPreviewDto> getNew() {
        return get(Comparator.comparing(Post::getPostDate),
                p -> true);
    }

    public List<PostPreviewDto> getPopular() {
        return get(Comparator.comparing(p -> {
                    Iterator<PostVote> iterator = p.getVotes().iterator();
                    int rating = 0;
                    while (iterator.hasNext())
                        rating += iterator.next().getVote().equals(VoteType.UPVOTE) ? 1 : -1;
                    return rating;
                }),
                p -> true);
    }

    public List<PostPreviewDto> getSubscriptions(User user) {
        List<Topic> subscriptions = user.getSubscriptions();
        return get(Comparator.comparing(Post::getPostDate),
                p -> subscriptions.contains(p.getTopic()));
    }

    public List<PostPreviewDto> getFollowed(User user) {
        List<User> followed = user.getFollowed();
        return get(Comparator.comparing(Post::getPostDate),
                p -> followed.contains(p.getAuthor()));
    }

    public List<PostPreviewDto> get(Comparator<Post> comparator, Predicate<Post> filter) {
        return postRepo.findAll().stream()
                .filter(filter)
                .sorted(comparator)
                .map(mapper::postToPreviewDto)
                .collect(Collectors.toList());
    }
}
