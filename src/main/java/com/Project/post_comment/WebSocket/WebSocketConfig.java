//package com.Project.post_comment.WebSocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//  @Override
//  public void configureMessageBroker(MessageBrokerRegistry registry) {
//    registry.enableSimpleBroker(
//      "/topic"); //the broker(messaging channels) who receives messages, here messages will be broadcasted
//    registry.setApplicationDestinationPrefixes(
//      "/app"); // my app will publish these messages to this endpoint: /app/update
//  }
//
//  @Override
//  public void registerStompEndpoints(StompEndpointRegistry registry) {
//    registry.addEndpoint("/ws")
//      .setAllowedOriginPatterns("*")
//      .withSockJS();
//  }
//}