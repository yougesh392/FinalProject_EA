package com.miu.MainApplication.model;

import java.util.List;

public class Post {

    private Long id;
    private String blogTitle;
    private String blogData;

    private List<Comment> comments;

    public Post() {
    }

    public Post(String blogTile, String blogData) {
        this.blogTitle = blogTile;
        this.blogData = blogData;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogData() {
        return blogData;
    }

    public void setBlogData(String blogData) {
        this.blogData = blogData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
