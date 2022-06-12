package com.miu.MainApplication.DTO;

public class PostDTO {
    private String postTitle;
    private String postData;

    public PostDTO(String postTitle, String postData) {
        this.postTitle = postTitle;
        this.postData = postData;
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
