package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MusicItemTest {

    MusicItem musicItem;

    @Before
    public void setUp() throws IllegalPriceException {
        musicItem = new MusicItem.Builder(InMemoryCatalog.catalogData.size() + 1).
                title("Down In The Valley").
                artist("The Head And The Heart").
                releaseDate("2011-04-19").
                price(11.99).
                musicCategory(MusicCategory.ALTERNATIVE).
                inCatalog(false).
                build();
    }

    @Test (expected = IllegalPriceException.class)
    public void testBuildWithNegativePrice() throws IllegalPriceException {
        musicItem = new MusicItem.Builder(InMemoryCatalog.catalogData.size() + 1).
                title("Down In The Valley").
                artist("The Head And The Heart").
                releaseDate("2011-04-19").
                price(-11.99).
                musicCategory(MusicCategory.ALTERNATIVE).
                inCatalog(false).
                build();
    }
}