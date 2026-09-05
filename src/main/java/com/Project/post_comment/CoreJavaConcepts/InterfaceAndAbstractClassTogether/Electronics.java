package com.Project.post_comment.CoreJavaConcepts.InterfaceAndAbstractClassTogether;

public class Electronics extends Product{

  public Electronics(String name, double price) {
    super(name, price);
  }
  @Override
  public double getDiscount() {
    return price * 0.2;
  }

  @Override
  public double calculateTax() {
    return (price - getDiscount()) * 0.15;
  }

}
