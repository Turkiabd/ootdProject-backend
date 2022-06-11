package com.example.imagetest.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {
    private Integer postId;
    private String postName;
    private String description;
    private Instant createAt;
}
