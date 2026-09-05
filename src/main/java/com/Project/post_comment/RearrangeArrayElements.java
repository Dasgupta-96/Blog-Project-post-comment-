package com.Project.post_comment;

import java.util.Arrays;

public class RearrangeArrayElements {

  public static void main(String[] args) {

    int[] nums = {3, 1, -2, -5, 2, -4};

    int[] result = new int[nums.length];

    int positiveIndex = 0, negIndex = 1;

    for (int i = 0; i < nums.length; i++) {

      if (nums[i] < 0) {
        result[negIndex] = nums[i];
        negIndex += 2;

      } else {
        result[positiveIndex] = nums[i];
        positiveIndex += 2;
      }

    }
    System.out.println(Arrays.toString(result));
  }
}
