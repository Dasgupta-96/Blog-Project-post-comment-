package com.Project.post_comment.CoreJavaConcepts.FunctionalInterfaceWithLambda;

public interface Calculator {
  int calculate(int a, int b);

  public static void main(String[] args) {

    Calculator add = (a, b) -> a + b;
    Calculator multiply = (a, b) -> a * b;

    System.out.println(add.calculate(10, 5));
    System.out.println(multiply.calculate(10, 5));


  }

}

