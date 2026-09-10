package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {

  public static void main(String[] args) {

    int[] arr = {16, 17, 4, 3, 5, 2};

    System.out.println(findLeaders(arr));
  }

  private static List<Integer> findLeaders(int[] arr) {

    List<Integer> resultSet = new ArrayList<>();

    int MIN_VALUE = Integer.MIN_VALUE;

    for (int i =arr.length -1; i>=0; i--) {

      if (arr[i] > MIN_VALUE) {
        resultSet.add(arr[i]);

        MIN_VALUE = arr[i];
      }
    }
    Collections.reverse(resultSet);
   return resultSet;
  }
}
