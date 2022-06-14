package com.miu.MainApplication.DTO;

public class PostSaveDTO {

    private String blogTitle;
    private String blogData;

    public PostSaveDTO(String blogTitle, String blogData) {
        this.blogTitle = blogTitle;
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


}
