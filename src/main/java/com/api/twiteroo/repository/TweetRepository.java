package com.api.twiteroo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.twiteroo.models.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query("SELECT t, u.avatar FROM Tweet t JOIN TweetUser.username u WHERE t.username = :username")
    Page<Object[]> findByUsernameWithUserDetails(String username, Pageable pageable);
}
