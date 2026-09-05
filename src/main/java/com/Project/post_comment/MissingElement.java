package com.Project.post_comment;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

public class MissingElement {
  public static void main(String[] args) {

    int[] nums = {3, 0, 1};
    int missingNumbersUsingXor = findMissingNumbersUsingXor(nums);
    System.out.println(missingNumbersUsingXor);
    int[] arr = {1, 2, 4, 5};

    int i1 = MissingNumbersUsingXor(arr);

    System.out.println("after xor: " +i1);

    int n = 5;

    Set<Integer> no = new HashSet<>();

    for (int num : arr) {
      no.add(num);
    }
    for (int i = 1; i <= n; i++) {
      if (!no.contains(i)) {
        System.out.println("missing no is: " + i);
        break;
      }
    }
  }

  private static int MissingNumbersUsingXor(int[] arr) {

    int xor = 0;
    for (int i = 1; i <= 5; i++) {

      xor ^= i;
    }

    for (int num : arr) {
      xor ^= num;

    }
    return xor;

  }

  private static int findMissingNumbersUsingXor(int[] nums) {

    int xor = nums.length;
    for (int i = 0; i < nums.length; i++) {

      xor ^= i;
      xor ^= nums[i];
    }
    return xor;

//    nums = [3,0,1]
//n = 3
//
//xor = 3
//
//i=0
//xor = 3 ^ 0 ^ 3 = 0
//
//i=1
//xor = 0 ^ 1 ^ 0 = 1
//
//i=2
//xor = 1 ^ 2 ^ 1 = 2
//
//Answer = 2
  }
}
