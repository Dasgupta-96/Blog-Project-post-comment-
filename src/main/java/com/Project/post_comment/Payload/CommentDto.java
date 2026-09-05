package com.Project.post_comment.Payload;

import com.Project.post_comment.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private int id;
    private String body;
    private String email;
    private Post posts;
}
