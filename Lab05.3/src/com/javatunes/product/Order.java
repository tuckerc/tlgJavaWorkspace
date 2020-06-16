/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {
  private String id;
  private OrderLocation orderLocation;
  private double total;
  private TaxCalculator taxCalculator;
  
  public Order(String id, OrderLocation orderLocation) {
    this.id = id;
    this.taxCalculator = TaxCalculatorFactory.getTaxCalculatorStrategy(orderLocation);
  }
  
  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public double processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    setTotal(cart.total());
    System.out.println("Subtotal: " + total);
    setTotal(total + taxCalculator.taxAmount(total));
    System.out.println("Grand total: " + total);
    return total;
  }

  public double getTotal() {
    return total;
  }

  private void setTotal(double total) {
    this.total = total;
  }

  public String getId() {
    return id;
  }
}