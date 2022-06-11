package com.example.imagetest.advice;

import com.example.imagetest.Exceptions.InvalidIdException;
import com.example.imagetest.Exceptions.PostNotFoundException;
import com.example.imagetest.model.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceHandler {




    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Api> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }




    @ExceptionHandler(value = PostNotFoundException.class)
    public ResponseEntity<Api> handlePostNotFound(PostNotFoundException postNotFoundException){
        String message=postNotFoundException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }
}
