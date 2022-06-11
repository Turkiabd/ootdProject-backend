package com.example.imagetest.Service;

import com.example.imagetest.Repo.UserRepository;
import com.example.imagetest.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {



    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository usersRepository) {
        this.userRepository = usersRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= userRepository.findUsersByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }

        return user;
    }
    }

