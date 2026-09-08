package com.Project;

import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatingNumbers {

  public static void main(String[] args) {

    int[] arr = {1, 2, 2, 4, 5};

    find(arr);
  }
  public static void find(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int num : arr) {

      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int repeating = -1;
    int missing = -1;

    for (int i = 1; i <= arr.length; i++) {

      int count = map.getOrDefault(i, 0);

      if (count == 2) {
        repeating = i;
      }

      if (count == 0) {
        missing = i;
      }
    }

    System.out.println("Repeating = " + repeating);
    System.out.println("Missing = " + missing);
  }

  //TODO: using XOR
  public static void findMissingRepeating(int[] arr) {

    int n = arr.length;

    long expectedSum = (long) n * (n + 1) / 2;

    long expectedSquareSum =
      (long) n * (n + 1) * (2L * n + 1) / 6;

    long actualSum = 0;
    long actualSquareSum = 0;

    for (int num : arr) {

      actualSum += num;
      actualSquareSum += (long) num * num;
    }

    long difference =
      expectedSum - actualSum;

    long squareDifference =
      expectedSquareSum - actualSquareSum;

    // missing - repeating = difference
    // missing + repeating = squareDifference / difference

    long sum =
      squareDifference / difference;

    long missing =
      (difference + sum) / 2;

    long repeating =
      sum - missing;

    System.out.println("Missing = " + missing);
    System.out.println("Repeating = " + repeating);
  }
}
