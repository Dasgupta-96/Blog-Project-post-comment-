package com.Project.post_comment;

public class SubArraysProductLessThanK {

  public static void main(String[] args) {

    int [] arr = {10, 5, 2, 6};

    int k = 100;

    System.out.println(findSubArrayProduct(arr, k));
  }

  private static int findSubArrayProduct(int[] arr, int k) {

    int product = 1;
    int left =0, count = 0;

    for (int right =0; right<arr.length; right++) {

      product*= arr[right];

      while (product >= k) {
        product /= arr[left];
        left++;
      }

      count += right - left + 1;
    }
    return count;
  }
}
