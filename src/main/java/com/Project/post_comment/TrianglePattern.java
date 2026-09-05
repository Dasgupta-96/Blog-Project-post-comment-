package com.Project.post_comment;

public class TrianglePattern {
  public static void main(String[] args) {
    int n = 5;
    for(int i =0; i<=n; i++){ // 0,1,2,3,4
      // for space
      for(int j=0; j<n-i-1; j++){
        System.out.print(" ");
      }
      // for star
      for(int j=0; j<2*i+1; j++){
        System.out.print("*");
      }
      // again for space
      for(int j=0; j<n-i-1; j++){
        System.out.print(" ");
      }
      System.out.println();

    }
    for (int i = 0; i<=6; i++) {

      for (int j = 0; j < i; j++) { // printing space
        System.out.print(" ");
      }
      for (int j = 0; j < 2 * n - (2 * i - 1); j++) {

        System.out.print("*");
      }
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
