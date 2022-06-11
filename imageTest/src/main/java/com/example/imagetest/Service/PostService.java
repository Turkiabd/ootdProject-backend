package com.example.imagetest.Service;


import com.example.imagetest.DTO.PostDTO;
import com.example.imagetest.DTO.PostResponse;
import com.example.imagetest.Exceptions.PostNotFoundException;
import com.example.imagetest.Repo.PostRepo;
import com.example.imagetest.model.Post;
import com.example.imagetest.model.Users;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PostService {

    private final PostRepo postRepo;
    private final UserService userService;

    public List<Post> getPosts(PostDTO postDTO) {
       return postRepo.findAll();
    }


//    public PostDTO creatPost(Post post){
//        PostDTO postDTO = new PostDTO();
//        postDTO.setPostId(post.getPostId());
//        postDTO.setPostName(post.getPostName());
//        postDTO.setDescription(post.getDescription());
//
//        return postDTO;
//    }





    public Post creatPost(PostDTO postDTO){
        Post post = new Post();
        post.setPostId(postDTO.getPostId());
        post.setPostName(postDTO.getPostName());
        post.setDescription(postDTO.getDescription());
        post.setCreateAt(Instant.now());

        return postRepo.save(post);
    }




    // find post by id

    public Post getPost(Integer id){
        Post post = postRepo.findById(id).orElseThrow(()->new PostNotFoundException(id.toString()));
        return post;
    }


    public void delPost(Integer id) {
        postRepo.deleteById(id);
    }


}
