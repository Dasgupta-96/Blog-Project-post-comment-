package com.Project.post_comment;

public class FestiveDiscount implements DiscountStrategy {
  @Override
  public double getDiscount() {
    return 10.0;
  }
}
