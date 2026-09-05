package com.Project.post_comment.CoreJavaConcepts.AbstractNotificationUseCase;

public abstract class TriggerRecipient implements Notification {

  protected String recipient;


  public TriggerRecipient(String recipient) {
    this.recipient = recipient;
  }
}
