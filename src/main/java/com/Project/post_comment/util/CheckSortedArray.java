package com.Project.post_comment.util;

// check if the array is sorted
public class CheckSortedArray {
  public static void main(String[] args) {
    int [] a = {1,2,3,4,5};

    boolean check = checkIfItsSorted(a);
    if (check) {
      System.out.println("yes the array is sorted");
    } else {
      System.out.println("Not sorted");
    }

  }

  private static boolean checkIfItsSorted(int[] a) {
    for (int i=1; i<a.length; i++) {

      if (a[i] >= a[i-1]) {

      }
      else {
        return false;
      }
    }
    return true;
  }


}
