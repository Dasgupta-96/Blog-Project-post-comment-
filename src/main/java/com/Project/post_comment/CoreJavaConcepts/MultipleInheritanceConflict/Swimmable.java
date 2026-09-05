package com.Project.post_comment.CoreJavaConcepts.MultipleInheritanceConflict;

public interface Swimmable {

  default void move() {
    System.out.println("Swiming");
  }
}
