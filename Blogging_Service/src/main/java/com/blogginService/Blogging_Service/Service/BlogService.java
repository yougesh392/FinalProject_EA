package com.blogginService.Blogging_Service.Service;

import com.blogginService.Blogging_Service.DAO.BlogDAO;
import com.blogginService.Blogging_Service.Model.Blogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogDAO blogDAO;

    @Override
    public void createBlog(String title, String data) {
        Blogging new_blog = new Blogging(title, data);
        blogDAO.save(new_blog);
    }

    @Override
    public Blogging readBlogByTitle(String title) {
        return blogDAO.findByTitle(title);
    }

    @Override
    public Blogging readBlogById(Long Id) {
        if (blogDAO.findById(Id).isPresent()) return blogDAO.findById(Id).get();
        else return null;
    }

    @Override
    public void updateBlog(Long id, String title, String data) {
        Blogging updated_blog = blogDAO.findById(id).get();
        updated_blog.setBlogData(data);
        updated_blog.setBlogTitle(title);
        blogDAO.save(updated_blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDAO.deleteById(id);
    }

    @Override
    public List<Blogging> getblogs() {
        return blogDAO.findAll();
    }

}
