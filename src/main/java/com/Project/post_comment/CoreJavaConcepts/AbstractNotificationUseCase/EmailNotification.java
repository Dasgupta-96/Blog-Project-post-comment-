package com.Project.post_comment.CoreJavaConcepts.AbstractNotificationUseCase;

public class EmailNotification extends TriggerRecipient {

  private String subject;
  private String body;

  public EmailNotification(String recipient, String subject, String body) {
    super(recipient);
    this.subject = subject;
    this.body = body;
  }
  @Override
  public void send() {
    System.out.println("sending email to recipient: "+ recipient + "subject is: "+ subject + "and the body: " + body);
  }

//  @Override
//  public void logNotification() {
//    super.logNotification();
//  }
}
