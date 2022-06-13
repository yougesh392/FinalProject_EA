package com.miu.MainApplication.DTO;

public class PostDTO {
    private String postTitle;
    private String postData;
    private Long Id;

    public PostDTO(String postTitle, String postData,Long id) {
        this.postTitle = postTitle;
        this.postData = postData;
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }
}
