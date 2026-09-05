package com.Project.post_comment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeHasCollisionResolved {

  private Long id;

  private String name;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeHasCollisionResolved employee = (EmployeeHasCollisionResolved) o;
    return Objects.equals(id,employee.getId()) &&  Objects.equals(name, employee.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public EmployeeHasCollisionResolved(Long id, String name) {
    this.id = id;
    this.name = name;
  }
  public EmployeeHasCollisionResolved(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {

    Map<EmployeeHasCollisionResolved, String> map = new HashMap<>();

    EmployeeHasCollisionResolved employee1 = new EmployeeHasCollisionResolved(1L, "Arkadeb");
    EmployeeHasCollisionResolved employee2= new EmployeeHasCollisionResolved(2L, "Ankit");
    EmployeeHasCollisionResolved employee3 = new EmployeeHasCollisionResolved(1L, "Arkadeb");

    map.put(employee1, "Engineer");
    map.put(employee2, "Doctor");
    map.put(employee3, "Manager");

    System.out.println(map.get(employee1));
    System.out.println(map.get(employee2));
    System.out.println(map.get(employee3));



  }
}
