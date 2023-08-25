package com.api.twiteroo.models;

import com.api.twiteroo.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
    
    public Tweet(TweetDTO req){
        this.username = req.username();
        this.text = req.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "avatar")
    private TweetUser user;

}
