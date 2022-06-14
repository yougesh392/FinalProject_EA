package com.blogginService.Blogging_Service.Service;

import com.blogginService.Blogging_Service.Model.Blogging;

import java.util.List;

public interface IBlogService {
    void createBlog(String title, String data);

    Blogging readBlogByTitle(String title);

    Blogging readBlogById(Long Id);

    void updateBlog(Long id, String title, String data);

    void deleteBlog(Long id);

    List<Blogging> getblogs();
}
