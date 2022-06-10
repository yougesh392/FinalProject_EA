package edu.miu.cs544.commentservice.service.impl;

import edu.miu.cs544.commentservice.dto.CommentDTO;
import edu.miu.cs544.commentservice.dto.CommentSaveDTO;
import edu.miu.cs544.commentservice.entity.Comment;
import edu.miu.cs544.commentservice.repository.CommentRepository;
import edu.miu.cs544.commentservice.service.ICommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@AllArgsConstructor
public class CommentServiceImpl implements ICommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(CommentSaveDTO commentSaveDTO) {
        Comment comment = modelMapper.map(commentSaveDTO, Comment.class);
        comment.setDate(LocalDateTime.now());
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDTO> findAll() {
        return StreamSupport
                .stream(commentRepository.findAll().spliterator(), false)
                .map(c -> modelMapper.map(c, CommentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, CommentDTO commentDTO) {
        Optional<Comment> c = commentRepository.findById(id);
        if (c.isPresent()){
            c.get().setText(commentDTO.getText());
            commentRepository.save(c.get());
        }
    }

    @Override
    public CommentDTO getById(Long id) {
        Optional<Comment> c = commentRepository.findById(id);
        return c.isPresent() ? modelMapper.map(c.get(), CommentDTO.class) : null;
    }

    @Override
    public List<CommentDTO> findAllByPostId(Long postId) {
        return StreamSupport
                .stream(commentRepository.findAllByPostId(postId).spliterator(), false)
                .map(c -> modelMapper.map(c, CommentDTO.class))
                .collect(Collectors.toList());
    }
}
