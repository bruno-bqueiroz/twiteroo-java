package com.api.twiteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.twiteroo.models.Tweet;

@Repository
public interface TweetRepository extends
JpaRepository<Tweet, Long> {
    
}
