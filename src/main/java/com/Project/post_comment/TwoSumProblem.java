package com.Project.post_comment;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumProblem {
  public static void main(String[] args) {
//
    int [] a = {-3, 0,1,2,3,3,2,4};
    int sum =5;
    Arrays.sort(a);
    Set<Set<Integer>> ans = findTwoSum(a, sum, 1);
    System.out.println(ans);

    int[] nums = {3, 2, 4, 6};
    int target = 9;
    int[] twoSum = findTwoSum(nums, target);
    for (int e : twoSum) {
      System.out.println(e);
    }

  }
  //TODO: 2 pointer
  static Set<Set<Integer>> findTwoSum(int [] a, int sum, int startPoint){

    Set<Set<Integer>> ans = new HashSet<>();
  int l =startPoint;
  int r = a.length-1;
  while (l<r){
    if(a[l]+a[r] > sum){
      r--;
    } else if (a[l]+a[r] < sum) {
      l++;
    }
    else {
//      List<Integer> temp = new ArrayList<>();
      Set<Integer> temp = new HashSet();
      temp.add(a[l]);
      temp.add(a[r]);
      ans.add(temp);
      l++;
      r--;

    }
  }
  return ans;

  }
  // TODO Using hashmap

  public static int [] findTwoSum(int [] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>(); //3, 2, 4, 6
    int storedElement = 0;
    for (int i=0; i<nums.length; i++) {
      // in hashmap i am going to store previously seen numbers and their indices
      storedElement = target - nums[i];

      if (map.containsKey(storedElement)) {
        return new int[]{map.get(storedElement), i};
      }
      map.put(nums[i], i);

    }
    return new int[] {1, -1};
  }
  //I use a HashMap to store previously seen numbers and their indices.
  // For every element, I calculate target - currentElement and check whether
  // that storedElement already exists in the map. If it exists, I've found the pair.
  // Otherwise, I store the current element and continue. This reduces the brute-force O(n²) solution to O(n)."


  //TODO: without sorting work with negetive
//  int[] a = {-3, 0, 1, 2, 3, 3, 2, 4};
//  int target = 6;
//
//  Set<Integer> set = new HashSet<>();
//
// for (int num : a) {
//
//    int complement = target - num;
//
//    if (set.contains(complement)) {
//      System.out.println(
//        "Pair: " + complement + ", " + num
//      );
//    }
//
//    set.add(num);
//  }

}
