package edu.miu.cs544.commentservice.repository;

import edu.miu.cs544.commentservice.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);
}
