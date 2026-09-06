package com.Project.post_comment.Service;

import com.Project.post_comment.Entity.Session;
import com.Project.post_comment.Entity.User;
import com.Project.post_comment.Exception.ResourceNotFoundException;
import com.Project.post_comment.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService{

  private static final int SESSION_LIMIT = 2;
  private final SessionRepository sessionRepository;

  @Override
  public void generateNewSession(User user, String refreshToken) {
    List<Session> existsSession = sessionRepository.findByUser(user);
  // Before creating the session check if the user already has an active session or not

    if (existsSession.size() == SESSION_LIMIT) {
      existsSession.sort(Comparator.comparing(Session :: getLastUsedAt));
      Session lastUsedSession = existsSession.get(0);
      sessionRepository.delete(lastUsedSession); // if already active session then delete the (LRU-> least recently used session) previously used session ad create new session using refresh token
    }
    Session session = Session.builder()
      .user(user).refreshToken(refreshToken)
      .build();

    sessionRepository.save(session);
  }

  @Override
  public void validateRefreshToken(String token) {
    // next time when client attempts to refresh the access token the refreshToken will nt b present in db and show exception
    Optional<Session> existsRefresh = sessionRepository.findByRefreshToken(token);
    if (existsRefresh == null) {
      throw new ResourceNotFoundException("Refresh Token not found!! you have logged in from some other device");
    }
    Session session = existsRefresh.get();
    session.setLastUsedAt(LocalDateTime.now());
    sessionRepository.save(session);
  }
}
