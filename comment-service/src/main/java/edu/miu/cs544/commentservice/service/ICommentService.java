package edu.miu.cs544.commentservice.service;

import edu.miu.cs544.commentservice.dto.CommentDTO;
import edu.miu.cs544.commentservice.dto.CommentSaveDTO;

import java.util.List;

public interface ICommentService {
    void save(CommentSaveDTO commentSaveDTO);
    List<CommentDTO> findAll();
    void delete(Long id);
    void update(Long id, CommentDTO commentDTO);
    CommentDTO getById(Long id);
    List<CommentDTO> findAllByPostId(Long postId);


}
