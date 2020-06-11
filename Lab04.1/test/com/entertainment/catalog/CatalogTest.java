/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  /**
   * findByBrand(String brand) should return a non-null and not
   * empty Collection if supplied with brand in the catalog.
   */
  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> matches = Catalog.findByBrand("Sony");
    assertNotNull(matches);
    assertFalse(matches.isEmpty());
  }

  /**
   * findByBrands(String ... brands) should return a non-null,
   * empty Map if supplied with zero invalid argument.
   */
  @Test
  public void testFindByBrandsNoMatchesZeroArgs() {
    Map<String, Collection<Television>> matches = Catalog.findByBrands();
    assertNotNull(matches);
    assertTrue(matches.isEmpty());
  }

  /**
   * findByBrands(String ... brands) should return a non-null,
   * empty Map if supplied with one invalid argument.
   */
  @Test
  public void testFindByBrandsNoMatchesOneArg() {
    Map<String, Collection<Television>> matches = Catalog.findByBrands("not a brand");
    assertNotNull(matches);
    assertTrue(matches.isEmpty());
  }

  /**
   * findByBrands(String ... brands) should return a non-null,
   * empty Map if supplied with multiple invalid arguments.
   */
  @Test
  public void testFindByBrandsNoMatchesMultipleArgs() {
    Map<String, Collection<Television>> matches =
            Catalog.findByBrands("Susan", "Larry", "Moe");
    assertNotNull(matches);
    assertTrue(matches.isEmpty());
  }

  /**
   * findByBrands(String ... brands) should return a non-null,
   * non-empty Map of Televisions when supplied with one valid
   * argument.
   */
  @Test
  public void testFindByBrandsWithMatchesOneArg() {
    Map<String, Collection<Television>> matches =
            Catalog.findByBrands("RCA");
    assertNotNull(matches);
    assertFalse(matches.isEmpty());
  }

  /**
   * findByBrands(String ... brands) should return a non-null,
   * non-empty Map of Televisions when supplied with multiple
   * valid arguments.
   */
  @Test
  public void testFindByBrandsWithMatchesMultipleArg() {
    Map<String, Collection<Television>> matches =
            Catalog.findByBrands("Hitachi", "RCA", "Zenith");
    assertNotNull(matches);
    assertFalse(matches.isEmpty());
  }

  /**
   * Should return the catalog. Catalog should be non-null.
   */
  @Test
  public void testGetInventoryNotNull() {
    Collection<Television> inventory = Catalog.getInventory();
    assertNotNull(inventory);
  }

  /**
   * Should return the catalog. Catalog should be non-empty.
   */
  @Test
  public void testGetInventoryNotEmpty() {
    Collection<Television> inventory = Catalog.getInventory();
    assertFalse(inventory.isEmpty());
  }

  /**
   * Should return the catalog. Catalog should be immutable.
   */
  @Test (expected = UnsupportedOperationException.class)
  public void testGetInventoryImmutable() {
    Catalog.getInventory().removeIf(television -> television.getBrand().equals("RCA"));
  }
}