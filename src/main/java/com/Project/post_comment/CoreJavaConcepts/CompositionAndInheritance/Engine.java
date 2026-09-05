package com.Project.post_comment.CoreJavaConcepts.CompositionAndInheritance;

class Engine {
  void start() {
    System.out.println("Engine started");
  }
}

class Car {
  private Engine engine = new Engine(); // HAS-A

  void startCar() {
    engine.start();
    System.out.println("Car ready");
  }
}

 class Test {
  public static void main(String[] args) {
    new Car().startCar();
  }
}