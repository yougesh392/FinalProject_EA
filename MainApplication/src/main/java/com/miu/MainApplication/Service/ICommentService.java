package com.miu.MainApplication.Service;

import com.miu.MainApplication.DTO.CommentDTO;
import com.miu.MainApplication.DTO.CommentSaveDTO;

import java.util.List;

public interface ICommentService {
    void save(CommentSaveDTO commentSaveDTO);
    List<CommentDTO> findAll();
    void delete(Long id);
    void update(Long id, CommentDTO commentDTO);
    CommentDTO getById(Long id);
    List<CommentDTO> findAllByPostId(Long postId);
}
