package com.Project.post_comment;

import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

  public Payment processPayment(String type) {
    if ("cash".equals(type)) {
      return new CashPayment();
    } else if ("upi".equals(type)) {
      return new UpiPayment();
    }
    return null;
  }
}
