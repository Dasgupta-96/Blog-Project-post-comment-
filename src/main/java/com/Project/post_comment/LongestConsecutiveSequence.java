package com.Project.post_comment;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {

//    int [] nums = {100,4,200,1,3,2};
    int [] nums = {0 ,1 , 6, -1};
    int longestConsecutiveSequence = findLongestConsecutiveSequence(nums);

    System.out.println("longest consecutive sequence is : "+longestConsecutiveSequence);
  }

  private static int findLongestConsecutiveSequence(int[] nums) {
    int longestLength = 0;
    Map<Integer, Boolean> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, false);
    }

    for (int num : nums) {
      int currentLength = 1;

      int nextNum = num +1;

      while (map.containsKey(nextNum) && map.get(nextNum) == FALSE) {

        currentLength++;

        map.put(nextNum, Boolean.TRUE);

        nextNum ++; // move to next number
      }
      int previousNum = num -1;
      while (map.containsKey(previousNum) && map.get(previousNum) == FALSE) {

        currentLength++;

        map.put(previousNum, Boolean.TRUE);

        previousNum --; // move to previous number
      }
      longestLength = Math.max(currentLength, longestLength);

    }
    return longestLength;


  }
}
