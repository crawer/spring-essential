package com.example.codingredditexample.repository;

import com.example.codingredditexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
