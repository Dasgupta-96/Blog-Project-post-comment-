package com.Project.post_comment.util;

public class LinearSearch {
  public static void main(String[] args) {

    //TODO: Linear search
    int [] x ={4,4,6,2,5,8}; // position of 5
    int num = 5;
    for (int i=0; i<x.length; i++) {
      if (x[i] == num) {
        System.out.println(i);
      }
    }
  }
}