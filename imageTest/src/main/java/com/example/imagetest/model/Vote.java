package com.example.imagetest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//design pattern
@Builder //construct the obj of Vote
public class Vote {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer voteId ;
    private VoteType voteType ;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId")
    private Post post ;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId")
   private Users users;









}
