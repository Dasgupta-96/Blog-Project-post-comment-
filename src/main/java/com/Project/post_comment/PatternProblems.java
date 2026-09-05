package com.Project.post_comment;

public class PatternProblems {
  public static void main(String[] args) {

    int n =5;
    for (int i=1; i<=n ; i++){
      for (int j =0; j<=n-i+1; j++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
