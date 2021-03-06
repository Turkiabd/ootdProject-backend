package com.example.imagetest.Repo;

import com.example.imagetest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users   findUsersByUsername(String username);
    Users findUsersByUserId(Integer userId);

}
