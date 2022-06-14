package com.miu.MainApplication.controller;

import com.miu.MainApplication.DTO.CommentDTO;
import com.miu.MainApplication.DTO.CommentSaveDTO;
import com.miu.MainApplication.Service.ICommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
@CrossOrigin
public class CommentController {
    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> getAllComments() {
        return commentService.findAll();
    }

    @PostMapping
    public void saveComments(@RequestBody CommentSaveDTO commentSaveDTO) {
        commentService.save(commentSaveDTO);
    }

    @GetMapping("/{id}")
    public CommentDTO betById(@PathVariable Long id) {
        return commentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

    @GetMapping("/post/{id}")
    public List<CommentDTO> getAllByPostId(@PathVariable Long id) {
        return commentService.findAllByPostId(id);
    }

    @PutMapping("/{postId}")
    public void update(@PathVariable Long postId, @RequestBody CommentDTO commentDTO){
        commentService.update(postId, commentDTO);
    }
}
