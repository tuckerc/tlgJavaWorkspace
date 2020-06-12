/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
  private ShoppingCart<Product> productCart;
  private ShoppingCart<MusicItem> musicCart;
  private ShoppingCart<MediaPlayer> mediaCart;
  Order productOrder;
  Order musicItemOrder;
  Order mediaPlayerOrder;
  
  @Before
  public void init() {
    productCart = new ShoppingCart<Product>();
    productCart.addItem(new MusicItem("CD-501"));
    productCart.addItem(new MediaPlayer("MP3-LP150"));
    productOrder = new Order.Builder(1L).
            shoppingCart(productCart).
            build();
    
    musicCart = new ShoppingCart<MusicItem>();
    musicCart.addItem(new MusicItem("CD-521"));
    musicCart.addItem(new MusicItem("CD-514"));
    musicItemOrder = new Order.Builder(2L).
            shoppingCart(musicCart).
            build();
    
    mediaCart = new ShoppingCart<MediaPlayer>();
    mediaCart.addItem(new MediaPlayer("AAC-PL233"));
    mediaPlayerOrder = new Order.Builder(3L).
            shoppingCart(mediaCart).
            build();
  }
  
  /**
   * TODO: create new Order for each cart above and pass cart to processOrder().
   *  For example, create three Order objects: "order-1", "order-2", "order-3."
   *  order-1 is for the contents of productCart,
   *  order-2 is for the contents of musicCart,
   *  order-3 is for the contents of meduaCart.
   */
  @Test
  public void testProcessCart() {
    assertEquals("Order id: 1\n" +
            "\tItems:\n" +
            "\t\tCD-501: \t$10.0\n" +
            "\t\tMP3-LP150: \t$50.0\n" +
            "\tOrder total: \t$60.0",
            productOrder.processCart());
    assertEquals("Order id: 2\n" +
            "\tItems:\n" +
            "\t\tCD-521: \t$10.0\n" +
            "\t\tCD-514: \t$10.0\n" +
            "\tOrder total: \t$20.0",
            musicItemOrder.processCart());
    assertEquals("Order id: 3\n" +
            "\tItems:\n" +
            "\t\tAAC-PL233: \t$50.0\n" +
            "\tOrder total: \t$50.0",
            mediaPlayerOrder.processCart());
  }
}