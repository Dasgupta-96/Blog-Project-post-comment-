package com.Project.post_comment.CoreJavaConcepts;

public class TestPayment {

  public static void main(String[] args) {

    CardPayment cardPayment = new CardPayment(10, "34982687865");

    UpiPayment upiPayment = new UpiPayment(20, "arko@upi");

    System.out.println(cardPayment.processPayment());
    System.out.println(upiPayment.processPayment());

    MainPayment [] mainPayments = {new CardPayment(10, "34982687865"),
      new UpiPayment(20, "arko@upi")};

    for (MainPayment mainPayment: mainPayments) {
      mainPayment.processPayment();
    }
  }
}
