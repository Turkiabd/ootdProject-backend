package com.example.imagetest.controller;


import com.example.imagetest.Response.FileUploadeResponse;
import com.example.imagetest.Service.FileUploaderService;
import com.example.imagetest.Service.ImageService;
import com.example.imagetest.model.Api;
import com.example.imagetest.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/pics")
@RequiredArgsConstructor


public class ImageController {

private final ImageService imageService;

    // upload image to database
    @PostMapping
    public ResponseEntity<Api> uploadPicToDB(@RequestParam("file")MultipartFile multipartFile){
        imageService.uploadPicToDB(multipartFile);

        return ResponseEntity.status(200).body(new Api("image uploaded tp database",200));


    }
}
