package com.Project.post_comment;

public class SmsService implements NotificationObserver {

  @Override
  public void update(String message) {
    System.out.println("SMS sent: " + message);
  }
}
