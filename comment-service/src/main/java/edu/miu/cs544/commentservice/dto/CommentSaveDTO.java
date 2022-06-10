package edu.miu.cs544.commentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentSaveDTO {
    private Long id;
    @NotNull
    @Size(min = 2, max = 254)
    private String text;
    @NotNull
    private long postId;
}
