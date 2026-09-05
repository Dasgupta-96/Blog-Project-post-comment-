package com.Project.post_comment.CoreJavaConcepts.EmployeeBonusUsingAbstractInterface;

public class Engineer extends Employee {

  public Engineer(String name, double salary) {

    super(name, salary);
  }

  @Override
  public double calculateBonus() {
    return salary * 0.5;
  }
}
