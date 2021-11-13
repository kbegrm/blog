package com.kem.blog.service;

import com.kem.blog.dto.Mapper;
import com.kem.blog.dto.topic.NewTopicDto;
import com.kem.blog.dto.topic.TopicDto;
import com.kem.blog.dto.topic.TopicPreviewDto;
import com.kem.blog.dto.topic.TopicUpdateDto;
import com.kem.blog.model.Post;
import com.kem.blog.model.Topic;
import com.kem.blog.model.User;
import com.kem.blog.repository.TopicRepo;
import com.kem.blog.repository.UserRepo;
import com.kem.blog.security.SecurityUserDetails;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class TopicService {

    private TopicRepo topicRepo;
    private UserRepo userRepo;
    private Mapper mapper;

    @Autowired
    public TopicService(TopicRepo topicRepo, UserRepo userRepo, Mapper mapper) {
        this.topicRepo = topicRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }



    public void create(NewTopicDto dto, SecurityUserDetails principal) {
        User user = principal.getUser();
        Topic topic = new Topic( dto.getTitle(), dto.getDescription(), user);
        topicRepo.save(topic);
    }

    public  TopicDto get(Long id) {
        Topic topic = topicRepo.getById(id);
        return mapper.topicToDto(topic);
    }

    public void updateDescription(TopicUpdateDto dto) {
        Topic topic = topicRepo.getById(dto.getId());
        topic.setDescription(dto.getUpdate());
    }


    // TODO filter in DB

    public List<TopicPreviewDto> getInOrder() {
        Comparator<Topic> comparator = Comparator.comparing(Topic::getTitle);
        return get(comparator);
    }

    public List<TopicPreviewDto> getPopular() {
        Comparator<Topic> comparator = Comparator.comparingInt(t -> t.getSubscribers().size());
        return get(comparator);
    }

    public List<TopicPreviewDto> getNew() {
        Comparator<Topic> comparator = Comparator.comparing(Topic::getCreationDate);
        return get(comparator);
    }

    private List<TopicPreviewDto> get(Comparator<Topic> comparator) {
        return topicRepo.findAll().stream()
                .sorted(comparator)
                .map(mapper::topicToPreviewDto)
                .collect(Collectors.toList());
    }
}
