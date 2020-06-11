package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {

    Television emptyTv;
    Television equalEmptyTv;
    Television brandOnlyTv;
    Television equalBrandOnlyTv;
    Television brandVolumeTv;
    Television equalBrandVolumeTv;
    Television brandDisplayTv;
    Television equalBrandDisplayTv;
    Television brandVolumeDisplayTv;
    Television equalBrandVolumeDisplayTv;

    @Before
    public void setUp() throws Exception {
        emptyTv = new Television();
        equalEmptyTv = new Television();
        brandOnlyTv = new Television("Sony");
        equalBrandOnlyTv = new Television("Sony");
        brandVolumeTv = new Television("Toshiba", 50);
        equalBrandVolumeTv = new Television("Toshiba", 50);
        brandDisplayTv = new Television("LG",
                DisplayType.LED);
        equalBrandDisplayTv = new Television("LG",
                DisplayType.LED);
        brandVolumeDisplayTv = new Television("LG", 10,
                DisplayType.LED);
        equalBrandVolumeDisplayTv = new Television("LG", 10,
                DisplayType.LED);
    }

    @Test
    public void testSetVolume_ValidArg() {
        brandVolumeDisplayTv.setVolume(35);
        assertEquals(35, brandVolumeDisplayTv.getVolume());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetVolume_InvalidArg_Low() {
        brandVolumeDisplayTv.setVolume(Television.MIN_VOLUME - 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetVolume_InvalidArg_High() {
        brandVolumeDisplayTv.setVolume(Television.MAX_VOLUME + 1);
    }

    @Test
    public void testChangeChannel_ValidArg() {
        try {
            brandDisplayTv.changeChannel(55);
            assertEquals(55, brandDisplayTv.getCurrentChannel());
        } catch (InvalidChannelException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = InvalidChannelException.class)
    public void testChangeChannel_InvalidArg_Low() throws InvalidChannelException {
        brandVolumeTv.changeChannel(Television.MIN_CHANNEL - 1);
    }

    @Test (expected = InvalidChannelException.class)
    public void testChangeChannel_InvalidArg_High() throws InvalidChannelException {
        brandVolumeTv.changeChannel(Television.MAX_CHANNEL + 1);
    }

    @Test
    public void testCompareTo_LessThan() {
        assertTrue(brandDisplayTv.compareTo(brandOnlyTv) < 0);
    }

    @Test
    public void testCompareTo_GreaterThan() {
        assertTrue(brandVolumeTv.compareTo(brandOnlyTv) > 0);
    }

    @Test
    public void testCompareTo_Equal() {
        assertTrue(brandDisplayTv.compareTo(equalBrandDisplayTv) == 0);
    }

    @Test
    public void testHashCode_Equal() {
        assertEquals(emptyTv.hashCode(), equalEmptyTv.hashCode());
    }

    @Test
    public void testHashCode_NotEqual() {
        assertNotEquals(brandDisplayTv.hashCode(), brandOnlyTv.hashCode());
    }

    @Test
    public void testEquals() {
        assertEquals(brandDisplayTv, equalBrandDisplayTv);
    }

    @Test
    public void testNotEquals() {
        assertNotEquals(emptyTv, brandVolumeDisplayTv);
    }
}