package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDiff {
  public static void main(String[] args) {
    int [] a = {1,2,8,9,14,15};
    Arrays.sort(a);
    List<List<Integer>> ans = minDiff(a);
    System.out.println(ans);
  }
  static List<List<Integer>> minDiff(int [] a){
    List<List<Integer>> ans = new ArrayList<>();
    int n = a.length;
    int minDiff = 10000;
    for (int i = 1; i<n; i++){
      if(a[i]- a[i-1] < minDiff){
        minDiff = a[i]- a[i-1];
      }
    }
    for (int i =1; i<n; i++){

      if (minDiff == a[i]- a[i-1]){

        List<Integer> temp = new ArrayList<>();
        temp.add(a[i-1]);
        temp.add(a[i]);
        ans.add(temp);

      }
    }
    return ans;
  }
}
