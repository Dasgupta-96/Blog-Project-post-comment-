package com.Project.post_comment;

public class MaxProductSubArray {

  public static void main(String[] args) {

    int[] nums = {2, 3, -2, 4};

    System.out.println(maxProductSubarray(nums));
  }

  private static int maxProductSubarray(int[] nums) {

    int leftProduct = 1;
    int rightProduct = 1;

    int ans = 1;

    for (int i =0; i<nums.length; i++) { // 2 , 3, -2, 4

      leftProduct = leftProduct == 0 ? 1 : leftProduct;
      rightProduct = rightProduct == 0 ? 1 : rightProduct;

      leftProduct *= nums[i];

      rightProduct *= nums[nums.length -1 - i];

      ans = Math.max(ans, Math.max(leftProduct, rightProduct));
    }
    return  ans;
  }
}
