package com.example.imagetest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Image {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer picId;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String picId;

    private String title;

    private String type;

    @Column(name = "Outfit_pic" , unique = false , nullable = false,length = 10000)
    //Return the contents of the file as an array of bytes.
    @Lob // save this field as large file type
    private byte [] pics;

    private Date date;


    @ManyToOne
    private Users users ;

}
