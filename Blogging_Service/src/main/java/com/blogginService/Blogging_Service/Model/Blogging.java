package com.blogginService.Blogging_Service.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Blogging {
    @Id
    @GeneratedValue
    private Long id;
    private String blogTitle;
    private String blogData;

    public Blogging() {
    }

    public Blogging(String blogTile, String blogData) {
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
}
