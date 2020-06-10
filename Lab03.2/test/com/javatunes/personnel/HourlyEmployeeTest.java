package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {

    Employee employee;
    Employee testEqualityEmployee;
    Employee testInequalityEmployeeName;
    Employee testInequalityEmployeeHireDate;
    Employee testInequalityEmployeeRate;
    Employee testInequalityEmployeeHours;

    @Before
    public void setUp() throws Exception {
        employee = new HourlyEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2020, 4, 18)),
                200.0,
                40.0
        );
        testEqualityEmployee = new HourlyEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2020, 4, 18)),
                200.0,
                40.0
        );
        testInequalityEmployeeName = new HourlyEmployee(
                "Bob",
                Date.valueOf(LocalDate.of(2020, 4, 18)),
                200.0,
                40.0
        );
        testInequalityEmployeeHireDate = new HourlyEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2020, 1, 12)),
                200.0,
                40.0
        );
        testInequalityEmployeeRate = new HourlyEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2020, 4, 18)),
                20.0,
                40.0
        );
        testInequalityEmployeeHours = new HourlyEmployee(
                "Chase",
                Date.valueOf(LocalDate.of(2020, 4, 18)),
                200.0,
                4.0
        );
    }

    @Test
    public void testPay() {
        assertEquals(200.0 * 40.0, employee.pay(), 0.001);
        assertNotEquals(0.0, employee.pay(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(HourlyEmployee.HOURLY_TAX_RATE * 200.0 * 40.0,
                employee.payTaxes(), 0.001);
        assertNotEquals(0.0, employee.payTaxes(), 0.001);
    }

    @Test
    public void testEquals() {
        assertEquals(testEqualityEmployee, employee);
        assertNotEquals(testInequalityEmployeeName, employee);
        assertNotEquals(testInequalityEmployeeHireDate, employee);
        assertNotEquals(testInequalityEmployeeHours, employee);
        assertNotEquals(testInequalityEmployeeRate, employee);
    }

    @Test
    public void testHashCode() {
        assertEquals(testEqualityEmployee.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeName.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeHireDate.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeHours.hashCode(), employee.hashCode());
        assertNotEquals(testInequalityEmployeeRate.hashCode(), employee.hashCode());
    }
}