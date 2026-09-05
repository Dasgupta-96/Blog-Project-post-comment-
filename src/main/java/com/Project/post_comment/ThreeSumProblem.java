package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

  public static void main(String[] args) {
    int[] a = {4, 2, -1, -3, 0, 1, 2, 3, 2, 3};
    Arrays.sort(a); // -3,-1,0,1,2,2,2,3,3,4
    List<List<Integer>> ans1 = new ArrayList<>();
    for (int i = 0; i < a.length - 2; i++) {
      List<List<Integer>> temp = findTwoSum(a, -a[i], i + 1);
      for (List<Integer> num : temp) {
        num.add(0, a[i]);
        ans1.add(num);
      }
      System.out.println(ans1);
    }
  }

  private static List<List<Integer>> findTwoSum(int[] a, int k, int firstIndex) {
    List<List<Integer>> ans = new ArrayList<>();
    int l = firstIndex;
    int r = a.length - 1;

    while (l < r) {
      if (l> firstIndex && a[l] == a[l-1]) {
        l++;
        continue;
      }
      if (r < a.length-1 && a[r] == a[r+1]) {
        r--;
        continue;
      }
      if (a[l] + a[r] < k) {
        l++;
      } else if (a[l] + a[r] > k) {
        r--;
      }
      else {
        List<Integer> temp = new ArrayList<>();
        temp.add(a[l]);
        temp.add(a[r]);
        ans.add(temp);
        l++;
        r--;
      }
    }
    return ans;
  }
}
