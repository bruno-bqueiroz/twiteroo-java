package com.api.twiteroo.dto;

public class TweetPageDTO {
    
    private String username;
    private int page; // Número da página (começando de 0)
    private int size; // Tamanho da página

    public String getKeyword() {
        return username;
    }
    public void setKeyword(String keyword) {
        this.username = username;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

}
