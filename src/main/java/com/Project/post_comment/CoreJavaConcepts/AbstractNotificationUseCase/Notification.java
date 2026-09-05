package com.Project.post_comment.CoreJavaConcepts.AbstractNotificationUseCase;

import java.time.LocalDateTime;

public interface Notification {

  void send();

  default void logNotification() {
    System.out.println("notification logged at: "+ LocalDateTime.now());
  }

}
