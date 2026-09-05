package com.Project.post_comment;

import org.springframework.stereotype.Component;

@Component("cash")
public class CashPayment implements Payment{
  @Override
  public void pay() {
    System.out.println("Paying using cash");
  }
}
