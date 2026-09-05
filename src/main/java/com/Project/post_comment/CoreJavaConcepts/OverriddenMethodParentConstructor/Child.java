package com.Project.post_comment.CoreJavaConcepts.OverriddenMethodParentConstructor;

public class Child extends Parent{

  private String value = "Initialized";

  public Child() {
    // when parents constructor runs, child fields are not initialized
    System.out.println("Child constructor: "+value);
  }

  @Override
  public void show() {
   System.out.println("Child show, value=" + value);
  }

  public static void main(String[] args) {

    Parent p = new Child();
    p.show();
  }
}
