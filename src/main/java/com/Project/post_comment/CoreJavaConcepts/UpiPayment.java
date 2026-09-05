package com.Project.post_comment.CoreJavaConcepts;

public class UpiPayment extends MainPayment {

  private String upiId;

  public UpiPayment(double amount, String upiId) {
    super(amount);
    this.upiId = upiId;
  }

  @Override
  public String processPayment() {
    return "Paid" + amount + "Via upi with upiId: " +upiId;
  }
}
