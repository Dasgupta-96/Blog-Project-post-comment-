//package com.Project.post_comment.WebSocket;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class NotificationController {
//
//  //TODO: Its a backend to front end real time communication(almost similar to kafka) system
//
//  @MessageMapping("/update")
//  @SendTo("/topic/notification")
//  public ScoreMessage sendNotification(ScoreMessage msg) {
//    return msg;
//  }
//
//}
