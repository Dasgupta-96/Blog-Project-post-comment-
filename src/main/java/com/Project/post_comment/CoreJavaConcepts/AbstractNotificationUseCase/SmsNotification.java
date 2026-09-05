package com.Project.post_comment.CoreJavaConcepts.AbstractNotificationUseCase;

public class SmsNotification extends TriggerRecipient {

  private String msg;

  public SmsNotification(String recipient, String msg) {
    super(recipient);
    this.msg = msg;
  }
  @Override
  public void send() {
    System.out.println("Sending sms to recipient: "+recipient +"message is: "+ msg);
  }
}
