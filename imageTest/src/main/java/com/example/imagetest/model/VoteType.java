package com.example.imagetest.model;



//decide the vote as it upvote or downvote bt enum

public enum VoteType {

    UP_VOTE(1), DOWN_VOTE(-1) ;

    private int direction ;

    VoteType(int direction){

    }


}
