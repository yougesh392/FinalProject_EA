package edu.miu.cs544.commentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentSaveDTO {
    private Long id;
    private String text;
    private long postId;
}
