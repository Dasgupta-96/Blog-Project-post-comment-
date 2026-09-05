package com.Project.post_comment.CoreJavaConcepts.OverriddenMethodParentConstructor;

public class Parent {

  public Parent() {
    System.out.println("Parent constructor");
    show();
  }

  public void show() {
    System.out.println("Parent show");
  }
}
