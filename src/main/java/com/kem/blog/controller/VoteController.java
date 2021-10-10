package com.kem.blog.controller;

import com.kem.blog.dto.VoteDto;
import com.kem.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/vote")
public class VoteController {

    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }




    @PostMapping("/comment")
    public void voteComment(VoteDto dto) {
        voteService.voteComment(dto);
    }

    @PostMapping("/post")
    public void votePost(VoteDto dto) {
        voteService.votePost(dto);
    }
}
