package com.miu.MainApplication.controller;

import com.miu.MainApplication.DTO.PostDTO;
import com.miu.MainApplication.Service.PostService;
import com.miu.MainApplication.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody PostDTO p) {
        postService.add(p);
        return new ResponseEntity<PostDTO>(p, HttpStatus.OK);
    }
    @GetMapping("/getAllPosts")
    public ResponseEntity<?> getPosts() {
        List<Post> posts = postService.getAll();
//        for (Post p :posts) {
//            p.setComments();
//        }
//        posts.stream().map(Post p =>{
//
//        })
        return new ResponseEntity<Post>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return new ResponseEntity<Post>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id,@RequestBody PostDTO p) {
        postService.update(p,id);
        return new ResponseEntity<Post>(HttpStatus.OK);
    }
}
