package com.Project.post_comment.CoreJavaConcepts.MultipleInheritanceConflict;

public interface Flyable {

  default void move() {
    System.out.println("Flying");
  }
}
