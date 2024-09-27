package com.ithotgi.springbootdeveloper.dto;

import com.ithotgi.springbootdeveloper.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentResponse {
    private Long id;
    private String content;

    public AddCommentResponse(Comment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
    }
}
