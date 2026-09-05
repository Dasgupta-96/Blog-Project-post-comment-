package com.Project.post_comment;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
  public static void main(String[] args) {

    int[] arr1 = {1, 2, 3, 4};
    int[] arr2 = {3, 4, 5, 6};

    //TODO: o/p is 3,4

    Set<Integer> no1 = new HashSet<>();
    Set<Integer> no2 = new HashSet<>();

    for (int a : arr1) {
      no1.add(a);
    }
    for (int b : arr2) {
      if (no1.contains(b)) {
        no2.add(b);
      }
    }

    System.out.println(no2);

  }
}
