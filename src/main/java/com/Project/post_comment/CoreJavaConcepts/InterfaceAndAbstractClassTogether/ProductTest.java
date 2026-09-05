package com.Project.post_comment.CoreJavaConcepts.InterfaceAndAbstractClassTogether;

public class ProductTest {

  public static void main(String[] args) {

    Product [] products = {new Electronics("Samsung", 20000.00),
      new Furniture("Sofa", 30000.00)};

    for (Product product : products) {
      product.productSlip();

    }
  }
}
