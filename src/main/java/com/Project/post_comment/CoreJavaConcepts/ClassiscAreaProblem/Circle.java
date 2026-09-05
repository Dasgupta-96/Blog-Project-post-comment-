package com.Project.post_comment.CoreJavaConcepts.ClassiscAreaProblem;

public class Circle extends Shape{

  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  double area() {
    return Math.PI * radius * radius;
  }
}
