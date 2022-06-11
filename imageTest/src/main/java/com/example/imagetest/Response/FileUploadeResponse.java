package com.example.imagetest.Response;

import lombok.Data;

@Data
public class FileUploadeResponse {
    private String fileId;
    private String fileType;
    private String message;
    private boolean uploadStatus;
    private String downloadUri;
}
