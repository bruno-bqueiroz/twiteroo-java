package com.api.twiteroo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.twiteroo.dto.TweetWithUserDetailsDTO;
import com.api.twiteroo.models.Tweet;

@Repository
public interface TweetRepositoryPage extends JpaRepository<Tweet, Long> {

    @Query("SELECT new com.api.twiteroo.dto.TweetWithUserDetailsDTO(t.username, u.avatar, t.text) " +
           "FROM Tweet t LEFT JOIN TweetUser u ON t.username = u.username WHERE t.username = :username")
    List<TweetWithUserDetailsDTO> findTweetsWithUserDetailsByUsername(@Param("username") String username);

    Page<Tweet> findByUsername(String username, Pageable pageable);
}
