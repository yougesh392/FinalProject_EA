package com.blogginService.Blogging_Service.Service;

import com.blogginService.Blogging_Service.DAO.BlogDAO;
import com.blogginService.Blogging_Service.Model.Blogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class BlogService {
    @Autowired
    private BlogDAO blogDAO;

    public void createBlog(String title, String data) {
        Blogging new_blog = new Blogging(title, data);
        blogDAO.save(new_blog);
    }

    public Blogging readBlogByTitle(String title) {
        return blogDAO.findByTitle(title);
    }

    public Blogging readBlogById(Long Id) {
        if (blogDAO.findById(Id).isPresent())
            return blogDAO.findById(Id).get();
        else return null;
    }

    public void updateBlog(Long id, String title, String data) {
//        Blogging updated_blog = blogDAO.findByTitle(title);
        Blogging updated_blog = blogDAO.findById(id).get();
        updated_blog.setBlogData(data);
        updated_blog.setBlogTitle(title);
        blogDAO.save(updated_blog);
    }

    public void deleteBlog(String title) {
        Blogging blog = blogDAO.findByTitle(title);
        blogDAO.delete(blog);
    }

    public Collection<Blogging> getblogs() {
        return blogDAO.findAll();
    }

}
