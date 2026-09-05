package com.Project.post_comment;

public class MaxConsecutiveOnes {
  public static void main(String[] args) {

    int [] x = {1,0,1,1,0,1,1,1};

    int count = 0;
    int maxi = 0;

    for (int i=0; i<x.length; i++) {
      if (x[i] ==1) {
        count++;
        maxi = Math.max(maxi, count);
      }
      else {
        count =0;
      }
    }
    System.out.println("max consecutive one is: "+maxi);
  }
}
