package com.Project.post_comment.CoreJavaConcepts.EmployeeBonusUsingAbstractInterface;

public class Doctor extends Employee {

  public Doctor(String name, double salary) {
    super(name, salary);
  }

  @Override
  public double calculateBonus() {
    return salary * 0.8;
  }
}
