package com.example.imagetest.Repo;

import com.example.imagetest.model.Post;
import com.example.imagetest.model.Users;
import com.example.imagetest.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepo extends JpaRepository<Vote, Integer> {

    //first find the user by post
   // Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, Users checkUser);



}
