package com.Project.post_comment;

public class ArraysRotation {
  public static void main(String[] args) {

    int [] a = {1,2,3,4,5}; // 2 3 4 5 1
    rotateByK(a,2);
    printTheArray(a);
  }

   static void printTheArray(int[] a) {
    for (int e :a){
      System.out.print(e);
    }
  }

  static void rotateByK(int []a, int k) {
    for(int i =0; i<k; i++) {

      int temp =a[0];
      for (int j =1; j<a.length; j++) {
        a[j-1]=a[j];
      }

      a[a.length-1]=temp;
    }
  }
}
