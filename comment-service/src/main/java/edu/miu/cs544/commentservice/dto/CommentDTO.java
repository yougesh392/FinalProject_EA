package edu.miu.cs544.commentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {
        private Long id;
        private String text;
        private LocalDateTime date;
        private long postId;
}
