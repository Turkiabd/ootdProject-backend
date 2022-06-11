package com.example.imagetest.Service;

import com.example.imagetest.Exceptions.InvalidIdException;
import com.example.imagetest.Repo.UserRepository;
import com.example.imagetest.model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers(){
        return  userRepository.findAll();
    }

    public void addUser(Users user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public void checkUser(Integer id) {

        Users users =userRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));

    }



    public void delUser(Integer id) {

        userRepository.deleteById(id);
    }


    }








