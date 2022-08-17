package com.miu.MainApplication.controller;

import com.miu.MainApplication.DTO.CommentDTO;
import com.miu.MainApplication.DTO.CommentSaveDTO;
import com.miu.MainApplication.Service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getAllComments() {
        return commentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComments(@RequestBody CommentSaveDTO commentSaveDTO) {
        commentService.save(commentSaveDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO betById(@PathVariable Long id) {
        return commentService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

    @GetMapping("/post/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getAllByPostId(@PathVariable Long id) {
        return commentService.findAllByPostId(id);
    }

    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long postId, @RequestBody CommentDTO commentDTO){
        commentService.update(postId, commentDTO);
    }
}
