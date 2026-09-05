package com.Project.post_comment;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public static void main(String[] args) {

    int [] nums = {2,2,1,1,1,2,2};

    //TODO: element appears more than n/2 here n =7 so 7/2 = 3 so in this array 2 appears more than 3
    int i = majorityElement(nums);
    System.out.println("Majority element is : " +i);
  }

  public static int majorityElement(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);

      if (map.get(num) > nums.length / 2) {
        return num; // o/p: 2
      }
    }

    return -1;
  }
}