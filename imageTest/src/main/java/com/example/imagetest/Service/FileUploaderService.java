package com.example.imagetest.Service;

import com.example.imagetest.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploaderService {

    public Image uploadPicToDB(MultipartFile file);
}
