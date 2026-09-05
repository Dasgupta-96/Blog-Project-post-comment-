package com.Project.post_comment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainsDuplicate {
  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 1};
    //TODO: Using stream api
    Set<Integer> no = new HashSet<>();
    List<Integer> list = Arrays.stream(nums)
      .boxed().filter(n -> !no.add(n)).toList();

    System.out.println("duplicate number is :" +list);

    if (isDuplicate(nums)){
      System.out.println("No is present");
    } else {
      System.out.println("Not present");
    }
  }

  private static boolean isDuplicate(int[] nums) {
    for (int num : nums) {

      Set<Integer> no = new HashSet<>();

      if (!no.add(num)) {

        return true;

      } else {
        no.add(num);
      }
    }
    return false;
  }
}
