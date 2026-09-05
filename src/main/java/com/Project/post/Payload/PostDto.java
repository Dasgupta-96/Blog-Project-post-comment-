package com.Project.post.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private int id;
    @NotEmpty
    @Size(min = 4,message = "title should consist of 4 characters")
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String description;
}
