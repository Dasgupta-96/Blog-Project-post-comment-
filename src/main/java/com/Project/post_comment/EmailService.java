package com.Project.post_comment;

public class EmailService implements NotificationObserver {
  public void update(String message) {
    System.out.println("Email sent: " + message);
  }
}