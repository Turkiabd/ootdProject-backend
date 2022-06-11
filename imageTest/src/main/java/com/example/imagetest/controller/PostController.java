package com.example.imagetest.controller;

import com.example.imagetest.DTO.PostDTO;
import com.example.imagetest.Service.PostService;
import com.example.imagetest.model.Api;
import com.example.imagetest.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @GetMapping
    public ResponseEntity<?> getPosts(PostDTO postDTO){
        return ResponseEntity.status(200).body(postService.getPosts(postDTO));
    }



    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO){
        postService.creatPost(postDTO);
        return ResponseEntity.status(201).body(new Api("post created" , 201));

    }



    @GetMapping("{id}")
    public ResponseEntity<?> getPostById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(postService.getPost(id));
    }


    @DeleteMapping("del/{id}")
    public ResponseEntity<?> delPost(@PathVariable Integer id){
        postService.delPost(id);
        return ResponseEntity.status(200).body("Post deleted");
    }


}
