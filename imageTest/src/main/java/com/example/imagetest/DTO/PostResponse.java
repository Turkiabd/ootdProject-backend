package com.example.imagetest.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private Integer id ;
    private String postName;
    private String userName;
    private Integer voteCount;
    private boolean upVote;
    private boolean downVote;

}
