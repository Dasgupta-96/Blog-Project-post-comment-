package com.Project.post_comment.CoreJavaConcepts;

public class CardPayment extends MainPayment{

  private String cardNum;

  public CardPayment(double amount, String cardNum) {
    super(amount); // this calls the parent class constructor
    this.cardNum = cardNum;
  }

  @Override
  public String processPayment() {
    return "Paid" + amount+ "via debit card ending: "
      +cardNum.substring(cardNum.length() -4);
  }
}
