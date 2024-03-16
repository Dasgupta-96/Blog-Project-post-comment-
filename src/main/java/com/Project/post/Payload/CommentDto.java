package com.Project.post.Payload;

import com.Project.post.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private int id;
    private String email;
    private String body;

    private Post posts;
}
