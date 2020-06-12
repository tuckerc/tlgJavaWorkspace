/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.Collection;

public class Order {
  private final Long id;
  private final ShoppingCart<? extends Product> cart;
  
  public static class Builder {
    private final Long id;
    private ShoppingCart<? extends Product> cart;

    public Builder(Long id) {
      this.id = id;
    }

    public Builder shoppingCart(ShoppingCart<? extends Product> cart) {
      this.cart = cart;
      return this;
    }

    public Order build() {
      return new Order(this);
    }
  }

  private Order(Builder builder) {
    this.id = builder.id;
    this.cart = builder.cart;
  }
  
  /**
   * TODO:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public String processCart() {
    StringBuffer sb = new StringBuffer();
    sb.append("Order id: ").append(this.id).append("\n\tItems:");
    Collection<? extends Product> items = this.cart.allItems();
    for(Product item : items) {
      sb.append("\n\t\t").append(item);
    }
    sb.append("\n\tOrder total: \t$").append(this.cart.total());
    return sb.toString();
  }
  
  public Long getId() {
    return id;
  }
}