/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

  Calculator calc;

  @Before
  public void setup() {
    calc = new Calculator();
  }

  @Test
  public void testAdd() {
    assertEquals(5, calc.add(1, 4));  // expected, actual
  }

  @Test
  public void divide() {
    assertEquals(4, calc.divide(20, 5), 0);
  }

  @Test
  public void isEven() {
    assertTrue(calc.isEven(20));
    assertFalse(calc.isEven(5));
  }

  @Test
  public void subtract() {
    assertEquals(-2, calc.subtract(3, 5));
    assertNotEquals(-2, calc.subtract(5, 3));
  }
}