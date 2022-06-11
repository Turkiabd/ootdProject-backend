package com.example.imagetest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    @NotEmpty(message = "post name is required")
    private String postName;
    @Column(nullable = true)
    private String description;

    private Integer voteCount = 0 ; // for the voting on the post , initially 0


    private Instant createAt; // show when post is posted

    // many posts to one user
    @ManyToOne(fetch = LAZY)
    private Users users ;



}
