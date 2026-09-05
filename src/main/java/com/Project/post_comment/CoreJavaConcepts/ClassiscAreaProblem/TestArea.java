package com.Project.post_comment.CoreJavaConcepts.ClassiscAreaProblem;

public class TestArea {
  public static void main(String[] args) {

    Shape [] shapes = {new Circle(5),
      new Rectangle(2, 3)};


    for (Shape shape : shapes) {
      System.out.println("Area is: " +shape.area());
    }
  }
}
