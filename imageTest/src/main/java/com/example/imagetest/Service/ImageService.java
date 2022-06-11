package com.example.imagetest.Service;


import com.example.imagetest.Repo.ImageRepo;
import com.example.imagetest.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService  {
    private ImageRepo imageRepo;




    public Image uploadPicToDB(MultipartFile multipartFile) {
        Image image = new Image();

        try {
            image.setPics(multipartFile.getBytes());
            image.setType(multipartFile.getContentType());
            image.setTitle(multipartFile.getOriginalFilename());
            imageRepo.save(image);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
    }





