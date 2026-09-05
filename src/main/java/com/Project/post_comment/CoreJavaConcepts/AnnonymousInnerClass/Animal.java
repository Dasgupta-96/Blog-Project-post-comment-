package com.Project.post_comment.CoreJavaConcepts.AnnonymousInnerClass;

public abstract class Animal {

  public abstract void sound();

  public void sleep() {
    System.out.println("Sleeping.....");
  }

  public static void main(String[] args) {

    //TODO: Object of an abstract can't be created but can resolve using inner class
    Animal animal = new Animal() {

      @Override
      public void sound() {
        System.out.println("Barking.........");
      }
    };

    animal.sound();
    animal.sleep();
  }
}
