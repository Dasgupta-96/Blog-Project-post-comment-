package com.Project.post_comment.CoreJavaConcepts.EmployeeBonusUsingAbstractInterface;

public class CalculateEmployee {

  public static void main(String[] args) {

    Employee[] employees = {
      new Engineer("Arkadeb", 50000),
      new Doctor("Tatwik", 80000)
    };

    for (Employee emp : employees) {
      emp.displaySalary();
    }
  }
}
