package com.Project.post_comment.CoreJavaConcepts.AbstractNotificationUseCase;

public class TestNotification {

  public static void main(String[] args) {

//    Notification [] notifications = {new EmailNotification("arkadeb", "otp", "otp is here"),
//    new SmsNotification("arkadeb", "hi")};
//
//    for (Notification notification : notifications) {
//      notification.send();
//    }

    EmailNotification emailNotification = new
      EmailNotification("arkadeb@gmail.com", "Greet", "email sent");

    SmsNotification smsNotification = new SmsNotification("024083472374", "sms sent");

    emailNotification.send();
    smsNotification.send();

  }
}
