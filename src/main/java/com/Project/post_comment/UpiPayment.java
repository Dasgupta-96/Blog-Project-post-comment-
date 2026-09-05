package com.Project.post_comment;

import org.springframework.stereotype.Component;

@Component("upi")
public class UpiPayment implements Payment{
  @Override
  public void pay() {
    System.out.println("Paying using upi");
  }
}
