package com.Project.post_comment;

import java.util.Arrays;

public class LargestElement {
  public static void main(String[] args) {

    int[] x = {3, 2, 1, 5, 9, 4};
//    Arrays.sort(x); // 123459
    int maxElement = Integer.MIN_VALUE;
    int secondMaxElement = Integer.MIN_VALUE;

    for (int num : x) {
      if (num > maxElement) {
        secondMaxElement = maxElement;
        maxElement = num;

      } else if (num > secondMaxElement) {
        secondMaxElement = num;
      }
      }
      if (secondMaxElement != Integer.MIN_VALUE) {
        System.out.println("second max element is :" + secondMaxElement);
      }
//    for (int i =0; i<x.length; i++){
//
//      if(x[i] > maxElement){
//
//        maxElement = x[i];
//      }
//    }
//    System.out.println("max element is : "+maxElement);
    }
  }


