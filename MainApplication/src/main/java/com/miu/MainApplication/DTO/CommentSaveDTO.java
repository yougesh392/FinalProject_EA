package com.miu.MainApplication.DTO;

public class CommentSaveDTO {
    private String text;
    private Long postId;

    public CommentSaveDTO(String text, Long postId) {
        this.text = text;
        this.postId = postId;
    }

    public CommentSaveDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
