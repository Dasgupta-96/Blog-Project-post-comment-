package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTriplets {
  public static void main(String[] args) {

    int [] a = {4,2,2,2,1,1,1,-1,-3,0,1,2,3,3,3};
    Arrays.sort(a);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i=0; i<a.length-2; i++){
//      if(i>0 && a[i]==a[i-1]) continue;

      List<List<Integer>> nums = findTwoSum(a, -a[i], i + 1); // got 2 pairs for +3
for (List<Integer> list : nums){
  list.add(0,a[i]);
  ans.add(list);
}
    }
    System.out.println(ans);

  }
  static List<List<Integer>> findTwoSum(int [] a, int sum, int startPoint){

    List<List<Integer>> ans = new ArrayList<>();
    int l =startPoint;
    int r = a.length-1;
    while (l<r){
      if(a[l]+a[r] > sum){
        r--;
      } else if (a[l]+a[r] < sum) {
        l++;
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
