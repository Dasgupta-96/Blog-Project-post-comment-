package com.Project.post_comment;

public class VipDiscount implements DiscountStrategy {
  @Override
  public double getDiscount() {
    return 5.0;
  }
}
