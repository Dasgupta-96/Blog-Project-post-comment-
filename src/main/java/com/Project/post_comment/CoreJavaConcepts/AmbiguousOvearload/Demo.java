package com.Project.post_comment.CoreJavaConcepts.AmbiguousOvearload;

public class Demo {

  public void show(String s) {
    System.out.println("String");
  }

  public void show(Integer i) {
    System.out.println("Integer");
  }

  public static void main(String[] args) {

    Demo demo = new Demo();
//    demo.show(null); // ambiguous method call
  }
}
