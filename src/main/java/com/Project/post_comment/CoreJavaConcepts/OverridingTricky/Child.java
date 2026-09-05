package com.Project.post_comment.CoreJavaConcepts.OverridingTricky;

public class Child extends Parent {

  void show(String data) {
    System.out.println("Child object: "+data);
  }

  public static void main(String[] args) {

    Parent parent = new Child();
    parent.show("Hello");
  }
}
