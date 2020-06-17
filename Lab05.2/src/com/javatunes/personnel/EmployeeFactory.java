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
import java.util.Map;

public class EmployeeFactory {
  
  private static String type;
  private static String name;
  private static String hireDate;
  private static String salary;
  private static String rate;
  private static String hours;

  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException {
    // return value
    Employee emp = null;

    if(inputMap.containsKey("type")) {
      type = inputMap.get("type");
      if(type.equals("SE")) {
        if(inputMap.containsKey("name") && inputMap.containsKey("hireDate")) {
          name = inputMap.get("name");
          hireDate = inputMap.get("hireDate");
          if(inputMap.containsKey("salary")) {
            salary = inputMap.get("salary");
            emp = new SalariedEmployee(name, Date.valueOf(hireDate), Double.valueOf(salary));
          } else {
            emp = new SalariedEmployee(name, Date.valueOf(hireDate));
          }
        } else {
          emp = new SalariedEmployee();
        }
      } else if(type.equals("HE")) {
        if(inputMap.containsKey("name") && inputMap.containsKey("hireDate")) {
          name = inputMap.get("name");
          hireDate = inputMap.get("hireDate");
          if(inputMap.containsKey("rate") && inputMap.containsKey("hours")) {
            hours = inputMap.get("hours");
            rate = inputMap.get("rate");
            emp = new HourlyEmployee(name, Date.valueOf(hireDate), Double.valueOf(rate), Double.valueOf(hours));
          } else {
            emp = new HourlyEmployee(name, Date.valueOf(hireDate));
          }
        } else {
          emp = new HourlyEmployee();
        }
      } else {
        throw new IllegalArgumentException("employee type must be EE or SE");
      }
    } else {
      throw new IllegalArgumentException("no employee type supplied");
    }
    
    return emp;
  }
}