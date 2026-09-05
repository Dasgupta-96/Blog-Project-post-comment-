package com.Project.post_comment;

public class DiscountManager {

  private DiscountStrategy discountStrategy;

  public DiscountManager(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;

  }

  public double calculate() {
    return discountStrategy.getDiscount();
  }
}
