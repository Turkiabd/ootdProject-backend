package com.example.imagetest.Service;


import com.example.imagetest.DTO.VoteDTO;
import com.example.imagetest.Exceptions.PostNotFoundException;
import com.example.imagetest.Repo.PostRepo;
import com.example.imagetest.Repo.UserRepository;
import com.example.imagetest.Repo.VoteRepo;
import com.example.imagetest.model.Post;
import com.example.imagetest.model.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static  com.example.imagetest.model.VoteType.UP_VOTE;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepo voteRepo ;
    private final PostRepo postRepo;
    private final UserService userService;
    private final UserRepository userRepository;

     // vote logic
    public void vote(VoteDTO voteDTO){
        //1st find post id
        Post post = postRepo.findById(voteDTO.getPostId())
                .orElseThrow(()-> new PostNotFoundException("Post not found!!"));
        //find the recent vote
//        Optional<Vote> voteByPostAndUser = voteRepo.
//                findTopByPostAndUserOrderByVoteIdDesc(post ,userService.);
        if(UP_VOTE.equals(voteDTO.getVoteType())){
            post.setVoteCount(post.getVoteCount()+1);
        }else {
            post.setVoteCount(post.getVoteCount()-1);
        }


        voteRepo.save(mapToVote(voteDTO, post));
        postRepo.save(post);





    }

    // not quite understand it
    private Vote mapToVote(VoteDTO voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .users(userRepository.findUsersByUserId(voteDto.getUserId()))
                .build();
    }










}
