package com.Project.post_comment.CoreJavaConcepts;

public abstract class MainPayment {

  protected double amount;

  public MainPayment(double amount) {
    this.amount = amount;
  }

  public abstract String processPayment();

}
