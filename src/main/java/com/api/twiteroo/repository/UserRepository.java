package com.api.twiteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.twiteroo.models.TweetUser;

@Repository
public interface UserRepository extends JpaRepository<TweetUser, Long> {
}
