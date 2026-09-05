package com.Project.post_comment;

public class MaxSumSubArray {

  public static void main(String[] args) {

    int[] arr = {2, 1, 5, 1, 3, 2};
    int k = 3;
    int windowSum = 0;
    int max = 0;

    int maxSubArrayWithSumK = findMaxSubArrayWithSumK(arr, k, windowSum, max);

    System.out.println(maxSubArrayWithSumK);

  }
  //TODO: Sliding window

  private static int findMaxSubArrayWithSumK(int[] arr, int k, int windowSum, int max) {
    for (int i = 0; i < k; i++) {

      windowSum += arr[i];

    }

    for (int i = k; i < arr.length; i++) {

      windowSum = windowSum - arr[i - k] + arr[i];
      max = Math.max(windowSum, max);
    }


    return max;
  }

}
