package com.miu.MainApplication.model;

import com.miu.MainApplication.DTO.CommentDTO;

import java.util.List;

public class Post {
    private Long id;
    private String blogTitle;
    private String blogData;

    private List<CommentDTO> comments;

    public Post() {
    }

    public Post(String blogTile, String blogData,Long id) {
        this.blogTitle = blogTile;
        this.blogData = blogData;
        this.id = id;
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

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogData='" + blogData + '\'' +
                ", comments=" + comments +
                '}';
    }
}
