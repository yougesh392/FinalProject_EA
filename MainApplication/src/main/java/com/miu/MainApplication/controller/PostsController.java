package com.miu.MainApplication.controller;

import com.miu.MainApplication.DTO.PostDTO;
import com.miu.MainApplication.DTO.PostSaveDTO;
import com.miu.MainApplication.Service.ICommentService;
import com.miu.MainApplication.Service.IPostService;
import com.miu.MainApplication.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private IPostService postService;
    @Autowired
    private ICommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody PostSaveDTO p) {
        postService.add(p);
        return new ResponseEntity<PostSaveDTO>(p, HttpStatus.OK);
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<?> getPosts() {
        Collection<Post> posts = postService.getAll();
        for (Post p : posts) {
            p.setComments(commentService.findAllByPostId(p.getId()));
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
      postService.delete(id);
      return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostSaveDTO p) {
        postService.update(p, id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
        }
        PostDTO p = postService.get(id);
        return new ResponseEntity<PostDTO>(p,HttpStatus.OK);
    }
}
