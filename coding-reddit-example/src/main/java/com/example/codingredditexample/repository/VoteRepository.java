package com.example.codingredditexample.repository;

import com.example.codingredditexample.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
