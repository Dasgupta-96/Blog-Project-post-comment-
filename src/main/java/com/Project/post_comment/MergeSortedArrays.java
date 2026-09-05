package com.Project.post_comment;

import java.util.Arrays;

public class MergeSortedArrays {

  public static void main(String[] args) {

    int[] a = {1, 3, 5, 7};
    int[] b = {2, 4, 6, 8};

    System.out.println(Arrays.toString(mergeSortedArrays(a, b)));
  // TODO: time complexity is O(n +m) cz we visit each element of both arrays
  }
  public static int[] mergeSortedArrays(int[] a, int[] b) {

    int[] result = new int[a.length + b.length];

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < a.length && j < b.length) {

      if (a[i] <= b[j]) {
        result[k] = a[i];
        i++;
      } else {
        result[k] = b[j];
        j++;
      }

      k++;
    }

    while (i < a.length) {
      result[k] = a[i];
      i++;
      k++;
    }

    while (j < b.length) {
      result[k] = b[j];
      j++;
      k++;
    }

    return result;
  }
}
