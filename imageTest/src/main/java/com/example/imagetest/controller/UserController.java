package com.example.imagetest.controller;

import com.example.imagetest.Service.UserService;
import com.example.imagetest.model.Api;
import com.example.imagetest.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("signup")
    public ResponseEntity<?> addUser(@RequestBody @Valid Users user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(message,400));
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new Api("New User added",200));
    }

    @GetMapping("user")
    public ResponseEntity<?> user(){
        return ResponseEntity.status(200).body(new Api("Hello User",200));
    }

//    @GetMapping("admin")
//    public ResponseEntity<?> admin(){
//        return ResponseEntity.status(200).body("Hello Admin");
//    }



    @GetMapping("/user/{id}")
    public ResponseEntity<Api> checkUserIsValid(@PathVariable Integer id){
        userService.checkUser(id);
        return ResponseEntity.status(200).body(new Api("Valid user",200));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delUser(@PathVariable Integer id){
        userService.delUser(id);
        return ResponseEntity.status(200).body("user deleted");
    }






}
