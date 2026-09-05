package com.Project.post_comment;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WaveArray {
  public static void main(String[] args) {
    List<Integer> integers = List.of(10, 20, 30, 35, 46);

    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();

   List j = integers.stream()
     .filter(e->e.equals(i))
     .collect(Collectors.toList());
//
//   if(j == i){
//
//
//   }

    System.out.println(j);

//
//    int [] x = {1,2,4,6,7,9};
//waveArray(x); // if the array is sorted then time complexity is O(logn)
//printArray(x);
//  }
//  static void printArray(int []x){
//    for (int e : x){
//      System.out.print(e);
//    }
//  }
//  static void waveArray(int []x){
//    int n =x.length;
//    int temp;
//
//    for (int i =1; i<n; i+=2){
//      temp = x[i];
//      x[i]= x[i-1];
//      x[i-1] = temp;
//    }

  }
}
