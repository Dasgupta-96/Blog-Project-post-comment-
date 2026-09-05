package com.Project.post_comment;

public class ElementAppearsOnlyOnce {

  public static void main(String[] args) {

    int[] nums = {10, 8, 19, 10, 8};

    System.out.println(singleNumber(nums));
  }

  public static int singleNumber(int[] nums) {
    int result = 0;

    for (int num : nums) {
      result ^= num;  // a ^ a = 0 , a^0 = a
    }

    return result;
  }
}
