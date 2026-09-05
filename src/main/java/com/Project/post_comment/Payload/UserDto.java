package com.Project.post_comment.Payload;

import com.Project.post_comment.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
}
