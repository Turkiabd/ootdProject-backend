package com.example.imagetest.controller;

import com.example.imagetest.DTO.VoteDTO;
import com.example.imagetest.Repo.VoteRepo;
import com.example.imagetest.Service.VoteService;
import com.example.imagetest.model.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;


    @PostMapping
    public ResponseEntity<Void> vote(@RequestBody VoteDTO voteDTO){
            voteService.vote(voteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
