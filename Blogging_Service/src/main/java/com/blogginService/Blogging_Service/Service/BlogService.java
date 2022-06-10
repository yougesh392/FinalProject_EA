package com.blogginService.Blogging_Service.Service;

import com.blogginService.Blogging_Service.DAO.BlogDAO;
import com.blogginService.Blogging_Service.Model.Blogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogDAO blogDAO;

    public void createBlog(String title, String data) {
        Blogging new_blog = new Blogging(title,data);
        blogDAO.save(new_blog);
    }
    public Blogging readBlog(String title) {
        return blogDAO.findByTitle(title);
    }
    public void updateBlog(String title,String data) {
        Blogging updated_blog = blogDAO.findByTitle(title);
        updated_blog.setBlogData(data);
        blogDAO.save(updated_blog);
    }
    public void deleteBlog(String title) {
        Blogging blog = blogDAO.findByTitle(title);
        blogDAO.delete(blog);
    }

}
