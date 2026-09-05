package com.Project.post_comment;

public class minLengthSubArray {
  public static void main(String[] args) {

    int [] a = {1,2,5,6,7,2};
    int target =7;
    System.out.println(minSumSubArray(a,target));

  }
  public static int minSumSubArray(int [] a, int target){
    int l =0, r=0;
    int minLength= Integer.MAX_VALUE; // 100000000000000000
    int curSum= 0;
    int n = a.length;
    while (r < n){
      curSum = curSum + a[r];

      while (curSum>= target){
        minLength = Math.min(minLength, r - l + 1);
        curSum= curSum-a[l];//8-0
        l++;
      }
        r++;
    }
    if (minLength== Integer.MAX_VALUE){ //223434325
      minLength=0;
    }
    return minLength;
  }
}
