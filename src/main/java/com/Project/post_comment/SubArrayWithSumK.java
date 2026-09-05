package com.Project.post_comment;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {

  public static void main(String[] args) {
    int[] nums = {10, 15, -5, 15, -10, 5};

    int[] nums1 = {9, 4, 20, 3, 10, 5};
    int target = 33;
    int i = subarraySumEqualK(nums1, target);
    System.out.println("Total sub array sum : " +i);
//    System.out.println(Arrays.toString(ints));
  }
//
//  public static int[] subarraySum(int[] nums, int target) {
//
//    int currSum = 0;
//    int start = 0;
//    int end = -1;
//
//    Map<Integer, Integer> map = new HashMap<>();
//
//    for (int i = 0; i < nums.length; i++) {
//
//      currSum += nums[i];
//
//      if (map.containsKey(currSum - target)) {
//        start = map.get(currSum - target) + 1;
//        end = i;
//        break;
//      }
//      map.put(currSum, i);
//
//    }
//    return new int[] {start, end};
//
//  }

  public static int subarraySumEqualK(int[] nums, int k) {

    int count = 0;
    int[] prefixSum = new int[nums.length];
    Map<Integer, Integer> map = new HashMap<>();

    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {

      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    for (int i = 0; i < prefixSum.length; i++) {

      // If prefix sum itself equals k
      if (prefixSum[i] == k) {
        count++;
      }

      // Check if (currentPrefix - k) was seen before
      count += map.getOrDefault(prefixSum[i] - k, 0);

      // Store current prefix sum
      map.put(prefixSum[i], i);
    }

    return count;

  }
}
