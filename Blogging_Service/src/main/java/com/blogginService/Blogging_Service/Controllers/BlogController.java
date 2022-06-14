package com.blogginService.Blogging_Service.Controllers;

import com.blogginService.Blogging_Service.Model.Blogging;
import com.blogginService.Blogging_Service.Service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogController {
    @Autowired
    IBlogService blogService;


    @GetMapping()
    public List<Blogging> getAllPosts() {
        return blogService.getblogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        Blogging blog;
        if (blogService.readBlogById(id) == null) {
            return new ResponseEntity(new BlogErrorType("Post with Id: " + id + " not available"), HttpStatus.NOT_FOUND);
        }
        blog = blogService.readBlogById(id);
         return new ResponseEntity<Blogging>(blog, HttpStatus.OK);
    }

    public ResponseEntity<?> getPostByTitle(@PathVariable String title) {
        Blogging blog;
        if (blogService.readBlogByTitle(title) == null) {
            return new ResponseEntity(new BlogErrorType("Post with Id: " + title + " not available"), HttpStatus.NOT_FOUND);
        }
        blog = blogService.readBlogByTitle(title);
        return new ResponseEntity<Blogging>(blog, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody Blogging blog) {
        blogService.createBlog(blog.getBlogTitle(), blog.getBlogData());
        return new ResponseEntity<Blogging>(blog, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Blogging blog) {
        if (blogService.readBlogById(id) == null) {
            return new ResponseEntity(new BlogErrorType("Post with Id: " + id + " not available"), HttpStatus.NOT_FOUND);
        }
        blogService.updateBlog(id, blog.getBlogTitle(), blog.getBlogData());
        return new ResponseEntity<Blogging>(blog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        if (blogService.readBlogById(id) == null) {
            return new ResponseEntity(new BlogErrorType("Post with Id: " + id + " not available"), HttpStatus.NOT_FOUND);
        }
        blogService.deleteBlog(id);
        return new ResponseEntity<>("Sucess",HttpStatus.NO_CONTENT);
    }

}
