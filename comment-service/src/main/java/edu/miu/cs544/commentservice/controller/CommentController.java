package edu.miu.cs544.commentservice.controller;

import edu.miu.cs544.commentservice.dto.CommentDTO;
import edu.miu.cs544.commentservice.dto.CommentSaveDTO;
import edu.miu.cs544.commentservice.service.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final ICommentService commentService;

    @PostMapping
    public void save(@RequestBody @Valid CommentSaveDTO commentSaveDTO){
        commentService.save(commentSaveDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        commentService.update(id, commentDTO);
    }

    @GetMapping
    public List<CommentDTO> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDTO getById(@PathVariable Long id){
        return commentService.getById(id);
    }

    @GetMapping("/get-by-post-id/{postId}")
    public List<CommentDTO> findAllByPostId(@PathVariable Long postId){
        return commentService.findAllByPostId(postId);
    }
}
