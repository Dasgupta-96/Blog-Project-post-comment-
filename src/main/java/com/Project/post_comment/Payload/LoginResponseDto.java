package com.Project.post_comment.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

  private int id;
  private String accessToken;
  private String refreshToken;
}
