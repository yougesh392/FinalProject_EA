package com.miu.MainApplication.model;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private String text;
    private LocalDateTime date;
    private Post post;

    public Comment() {
    }

    public Comment(Long id, String text, LocalDateTime date, Post post) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
