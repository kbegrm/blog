package com.kem.blog.controller;

import com.kem.blog.dto.VoteDto;
import com.kem.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vote")
@Validated
public class VoteController {

    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }




    @PostMapping("/comment")
    public void voteComment(@Valid @RequestBody VoteDto dto) {
        voteService.voteComment(dto);
    }

    @PostMapping("/post")
    public void votePost(@Valid @RequestBody VoteDto dto) {
        voteService.votePost(dto);
    }
}
