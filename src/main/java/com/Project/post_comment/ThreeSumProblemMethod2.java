package com.Project.post_comment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblemMethod2 {

  public static void main(String[] args) {

    int[] arr = {-1, 0, 1, 2, -1, -4};

    System.out.println(findThreeSum(arr, 0));

  }

  static Set<List<Integer>> findThreeSum(int[] arr, int target) {

    Arrays.sort(arr);

    Set<List<Integer>> result = new HashSet<>();

    for (int i = 0; i < arr.length - 2; i++) {

      int left = i + 1;
      int right = arr.length - 1;

      while (left < right) {

        int currentSum = arr[i] + arr[left] + arr[right];

        if (currentSum == target) {

          result.add(Arrays.asList(arr[i], arr[left], arr[right]));

          left++;
          right--;

        } else if (currentSum < target) {

          left++;

        } else {

          right--;
        }
      }
    }

    return result;
  }

}
