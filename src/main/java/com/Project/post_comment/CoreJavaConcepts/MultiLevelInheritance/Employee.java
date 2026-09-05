package com.Project.post_comment.CoreJavaConcepts.MultiLevelInheritance;


public class Employee extends Person {

  protected int empId;

  public Employee(String name, int empId) {
    super(name);
    this.empId = empId;
  }

  @Override
  public void display() {
    super.display();
    System.out.println("empID is : " + empId);
  }
}
