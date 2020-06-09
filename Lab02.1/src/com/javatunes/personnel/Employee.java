/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Objects;

public abstract class Employee {
  private String name;
  private Date hireDate;
  
  public Employee() {
  }
  
  public Employee(String name, Date hireDate) {
    setName(name);
    setHireDate(hireDate);
  }

  public abstract void pay();
  
  public void work() {
    System.out.println(getName() + " working hard since " + getHireDate());
  }
  
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Date getHireDate() {
    return this.hireDate;
  }
  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee)) return false;
    Employee employee = (Employee) o;
    return Objects.equals(getName(), employee.getName()) &&
            Objects.equals(getHireDate(), employee.getHireDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHireDate());
  }
}