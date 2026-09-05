package com.Project.post_comment.CoreJavaConcepts.ClassiscAreaProblem;

public class Rectangle extends Shape{

  double length, width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }
  @Override
  double area() {

    return length * width;
  }
}
