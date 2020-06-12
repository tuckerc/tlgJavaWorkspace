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

import java.util.Collection;

public class ShoppingCartTest {

  ShoppingCart<Product> productCart;
  Collection<Product> productCartItems;
  ShoppingCart<MusicItem> musicItemCart;
  Collection<MusicItem> musicItemCartItems;
  ShoppingCart<MediaPlayer> mediaPlayerCart;
  Collection<MediaPlayer> mediaPlayerCartItems;

  @Before
  public void setUp() {
    productCart = new ShoppingCart<>();
    productCart.addItem(new MusicItem("CD-501"));
    productCart.addItem(new MediaPlayer("MP3-LP150"));
    productCartItems = productCart.allItems();
    musicItemCart = new ShoppingCart<>();
    musicItemCart.addItem(new MusicItem("CD-521"));
    musicItemCart.addItem(new MusicItem("CD-514"));
    musicItemCartItems = musicItemCart.allItems();
    mediaPlayerCart = new ShoppingCart<>();
    mediaPlayerCart.addItem(new MediaPlayer("AAC-PL233"));
    mediaPlayerCartItems = mediaPlayerCart.allItems();
  }

  /**
   * Product-based shopping cart, allows all types of Products.
   */
  @Test
  public void testProductCart() {
    assertEquals(2, productCart.size());
  }
  
  /**
   * MusicItem-only shopping cart.
   * May be needed if we need to invoke MusicItem-specific functionality.
   * NOTE: we would of course do some OO analysis and try to avoid working
   * with MusicItem directly (see testProductCart above).
   * However, our ShoppingCart should be able to handle such a case. 
   */
  @Test
  public void testMusicItemCart() {
    assertEquals(2, musicItemCart.size());
  }
  
  /**
   * MediaPlayer-only shopping cart.
   * See comments above for MusicItem cart.
   */
  @Test
  public void testMediaPlayerCart() {
    assertEquals(1, mediaPlayerCart.size());
  }

  /**
   * Call to allItems() should return a non-null collection
   * of items in the cart.
   */
  @Test
  public void testAllItemsNotNull() {
    assertNotNull(productCartItems);
    assertNotNull(musicItemCartItems);
    assertNotNull(mediaPlayerCartItems);
  }

  /**
   * Call to allItems() should return a collection with the
   * proper size based on size of cart.
   */
  @Test
  public void testAllItemsCorrectSize() {
    assertEquals(productCart.size(), productCartItems.size());
    assertEquals(musicItemCart.size(), musicItemCartItems.size());
    assertEquals(mediaPlayerCart.size(), mediaPlayerCartItems.size());
  }

  /**
   * Call to allItems() should return an immutable collection
   * of the items in the cart.
   */
  @Test (expected = UnsupportedOperationException.class)
  public void testAllItemsImmutable() {
    productCartItems.clear();
  }

  /**
   * Call to total() should produce the correct total price
   * of items in cart.
   */
  @Test
  public void testTotalCorrectTotalPrice() {
    assertEquals(60.0, productCart.total(), 0.001);
    assertEquals(20.0, musicItemCart.total(), 0.001);
    assertEquals(50.00, mediaPlayerCart.total(), 0.001);
  }
}