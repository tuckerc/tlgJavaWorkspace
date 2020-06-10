package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    Employee employee;
    Employee testEqualityEmployee;
    Employee testInequalityEmployeeName;
    Employee testInequalityEmployeeHireDate;
    Employee testInequalityEmployeeSalary;

    @Before
    public void setUp() throws Exception {
        employee = new SalariedEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2019, 1, 12)),
                200000.0
        );
        testEqualityEmployee = new SalariedEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2019, 1, 12)),
                200000.0
        );
        testInequalityEmployeeName = new SalariedEmployee(
                "Bob",
                Date.valueOf(LocalDate.of(2019, 1, 12)),
                200000.0
        );
        testInequalityEmployeeHireDate = new SalariedEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2014, 1, 12)),
                200000.0
        );
        testInequalityEmployeeSalary = new SalariedEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2019, 1, 12)),
                100000.0
        );
    }

    @Test
    public void testPay() {
        assertEquals(200000.0, employee.pay(), 0.001);
        assertNotEquals(0.0, employee.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(SalariedEmployee.SALARIED_TAX_RATE * 200000.0,
                employee.payTaxes(), 0.001);
        assertNotEquals(0.0, employee.payTaxes(), 0.001);
    }

    @Test
    public void testEquals() {
        assertEquals(testEqualityEmployee, employee);
        assertNotEquals(testInequalityEmployeeName, employee);
        assertNotEquals(testInequalityEmployeeHireDate, employee);
        assertNotEquals(testInequalityEmployeeSalary, employee);
    }

    @Test
    public void testHashCode() {
        assertEquals(testEqualityEmployee.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeName.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeHireDate.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeSalary.hashCode(), employee.hashCode());
    }
}