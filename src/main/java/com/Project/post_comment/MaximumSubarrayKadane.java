package com.Project.post_comment;

public class MaximumSubarrayKadane {
  public static void main(String[] args) {

    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int i = kadanesTheorem(arr);

    System.out.println(i);
  }


  public static int kadanesTheorem(int[] arr) {

    int currentSum = 0;

    int maxSum = Integer.MIN_VALUE;

    int start = 0;
    int end = 0;
    int tempStart = 0;

    for (int i = 0; i < arr.length; i++) {

      currentSum += arr[i];

      if (currentSum > maxSum) {
        maxSum = currentSum;
        start = tempStart;
        end = i;
      }
//      maxSum = Math.max(maxSum, currentSum);

      if (currentSum < 0) {
        currentSum = 0;
        tempStart = i + 1;
      }
    }
    for (int i = start; i<=end; i++) {
      System.out.print(arr[i] + " ");
    }

    return maxSum;
  }
}
