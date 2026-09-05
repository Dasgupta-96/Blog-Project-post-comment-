package com.Project.post_comment.CoreJavaConcepts.InterfaceAndAbstractClassTogether;

public abstract class Product implements Taxable {

  protected String name;

  protected double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public abstract double getDiscount();

  public void productSlip() {
    System.out.println("product name is: " +name+ " price is :" +price+ " tax incurred: "
      + calculateTax() + " discount" + getDiscount());


  }

}
