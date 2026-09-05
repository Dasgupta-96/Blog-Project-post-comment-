class Parent {
  void show(int a) {
    System.out.println("Parent class: " + a);
  }
}

class Child extends Parent {
  void show(String str) {
    System.out.println("Child class: " + str);
  }
}

public class Test {
  public static void main(String[] args) {
    Parent obj = new Child();
    obj.show(10);  // What will be the output?
  }
}
