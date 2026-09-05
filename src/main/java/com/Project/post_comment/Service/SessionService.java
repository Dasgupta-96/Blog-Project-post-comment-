package com.Project.post_comment.Service;

import com.Project.post_comment.Entity.User;

public interface SessionService {

  void generateNewSession(User user, String refreshToken);

  void validateRefreshToken(String token);
}
