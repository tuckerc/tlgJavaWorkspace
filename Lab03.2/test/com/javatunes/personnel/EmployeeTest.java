package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Target;
import java.sql.Date;
import java.util.Objects;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee employeeA;
    Employee employeeB;

    @Before
    public void setUp() throws Exception {
        employeeA = new Employee("Chase",
                Date.valueOf("2020-05-18")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
        employeeB = new Employee("Chase",
                Date.valueOf("2020-05-18")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
    }

    @Test
    public void testEquals() {
        assertEquals(employeeA, employeeB);
    }

    @Test
    public void testNotEquals() {
        employeeB.setHireDate(Date.valueOf("1771-05-04"));
        assertNotEquals(employeeA, employeeB);
    }

    @Test
    public void testHashCode() {
        assertEquals(employeeA.hashCode(), employeeB.hashCode());
    }

    @Test
    public void testNotEqualHashCodes() {
        employeeB.setHireDate(Date.valueOf("1771-05-04"));
        assertNotEquals(employeeA.hashCode(), employeeB.hashCode());
    }
}