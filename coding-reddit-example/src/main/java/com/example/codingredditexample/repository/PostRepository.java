package com.example.codingredditexample.repository;

import com.example.codingredditexample.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
