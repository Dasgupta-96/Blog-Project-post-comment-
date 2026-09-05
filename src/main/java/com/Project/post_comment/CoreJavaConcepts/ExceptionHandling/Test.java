package com.Project.post_comment.CoreJavaConcepts.ExceptionHandling;

public class Test {

  static int test() {
    try {
      return 1;
    } catch (Exception e) {
      return 2;
    } finally {
      System.out.println("Finally");
      return 3; // here it prints Finally then 3 cz it overrides return 1 in try
    }
  }

  public static void main(String[] args) {

    System.out.println(test());
  }

}
