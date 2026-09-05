package com.Project.post_comment.CoreJavaConcepts.ExceptionTricky;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
  void show() throws IOException {
    System.out.println("Parent");
  }
}

class Child extends Parent {

  @Override
  void show() throws FileNotFoundException { // narrower — OK
    System.out.println("Child");
  }

  public static void main(String[] args) throws IOException {

    Parent parent = new Child();
    parent.show();
  }

}
