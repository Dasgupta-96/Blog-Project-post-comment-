package com.Project.post_comment.CoreJavaConcepts.EmployeeBonusUsingAbstractInterface;

public abstract class Employee {
//TODO: purpose of abstract is initialize a common field, running this common logic in all sub classes
  protected String name;
  protected double salary;

  public Employee(String name, double salary) {
    this.name = name;
    this.salary= salary;

  }
  public abstract double calculateBonus();

  public void displaySalary() {
    System.out.println("name: "+ name + "salary: " + salary +"Salary after Bonus: " + calculateBonus());
  }


}
