package com.api.twiteroo.dto;

public class TweetWithUserDetailsDTO {
    
    private String username;
    private String avatar;
    private String text;

    public TweetWithUserDetailsDTO(String username, String avatar, String text) {
        this.username = username;
        this.avatar = avatar;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
}
