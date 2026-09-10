package com.Project.post_comment;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {

    int [] num = {2 ,1, 3, 4};

    System.out.println(Arrays.toString(findProductOfArrayExceptSelf(num)));


  }

  private static int [] findProductOfArrayExceptSelf(int[] num) {

    // Array to store all the left manipulation
    int [] left = new int[num.length];

    // Array to store all the right manipulation
    int [] right = new int[num.length];

    left[0] =1;

    for (int i=1; i<num.length; i++) { // 2 1 3 4

      left[i] = left[i -1] * num[i -1]; // 1, 2, 2, 6

    }
    right[num.length -1] = 1;

      for (int i = num.length -2; i> -1; i--) {
      right[i] = right[i+1] * num[i+1]; // 12 ,12 ,4 ,1
    }

    int [] ans = new int[num.length];

    for (int i =0; i<num.length; i++) {
      ans[i] = left[i] * right[i];
    }

    return ans;

  }
}
