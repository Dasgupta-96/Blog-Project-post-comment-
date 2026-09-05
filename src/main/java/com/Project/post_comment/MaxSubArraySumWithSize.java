package com.Project.post_comment;

public class MaxSubArraySumWithSize {

  public static void main(String[] args) {

    int[] arr = {2, 1, 5, 1, 3, 2, 7};
    int k = 3;

    System.out.println(findMaxSubArrayWithSizeK(arr, k));
  }

  private static int findMaxSubArrayWithSizeK(int[] arr, int k) {

    int windowSum =0;
    int maxSum = 0;

    int startIndex =0;
    int endIndex = 0;

    for (int i =0; i<k; i++) {

      windowSum += arr[i];
    }
     maxSum = windowSum;
    for (int i =k; i<arr.length; i++) {  //2, 1, 5, 1, 3, 2}

      windowSum = windowSum - arr[i -k] + arr[i];

      if (windowSum > maxSum) {

        startIndex = i - k + 1;
        endIndex =i;
      }

      maxSum = Math.max(maxSum, windowSum);
    }

    for (int i = startIndex; i<=endIndex; i++) {
      System.out.println(arr[i] + " ");
    }

    return maxSum;
  }
}
