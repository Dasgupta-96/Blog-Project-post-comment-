package com.Project.post_comment.CoreJavaConcepts.MultipleInheritanceConflict;

public class Duck implements Flyable, Swimmable{

  @Override
  public void move() {
    Swimmable.super.move();
  }

  public static void main(String[] args) {

    Duck duck = new Duck();
    duck.move();
  }
}
