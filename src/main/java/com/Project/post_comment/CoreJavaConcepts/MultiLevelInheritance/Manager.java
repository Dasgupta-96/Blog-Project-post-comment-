package com.Project.post_comment.CoreJavaConcepts.MultiLevelInheritance;

public class Manager extends Employee{

  protected int teamSize;

  public Manager(String name, int empId,int teamSize ) {
    super(name, empId);
    this.teamSize = teamSize;
  }
  @Override
  public void display() {
    super.display();
    System.out.println("team size is  : " + teamSize);
  }

  public static void main(String[] args) {

    Person person = new Manager("Arkadeb", 101, 10);
    person.display();
  }
}
