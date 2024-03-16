package com.Project.post.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
}
