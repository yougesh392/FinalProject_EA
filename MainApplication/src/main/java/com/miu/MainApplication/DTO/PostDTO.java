package com.miu.MainApplication.DTO;

public class PostDTO {
    private String blogTitle;
    private String blogData;
    private Long id;

    public PostDTO() {
    }

    public PostDTO(Long id, String blogTitle, String blogData) {
        this.blogTitle = blogTitle;
        this.blogData = blogData;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
