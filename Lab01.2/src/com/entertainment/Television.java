package com.entertainment;

import java.util.Objects;

/**
 * Television Class
 */
public class Television implements Comparable<Television> {
    // class constants
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    // instance variables
    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();
    private DisplayType displayType;

    // constructors

    /**
     * No value constructor for Television.
     */
    public Television() {}

    /**
     * Television constructor with brand only
     * @param brand Television brand
     */
    public Television(String brand) {
        this.setBrand(brand);
    }

    /**
     * Television constructor with brand and volume.
     * @param brand Television brand
     * @param volume Television volume
     */
    public Television(String brand, int volume) {
        this(brand);
        try {
            this.setVolume(volume);
        } catch (IllegalVolumeAssignmentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Television constructor with brand, volume, and display type.
     * @param brand Television brand
     * @param volume Television volume
     * @param displayType Television display type.
     */
    public Television(String brand, int volume, DisplayType displayType) {
        this(brand, volume);
        setDisplayType(displayType);
    }

    // getters and setters

    /**
     * Getter for Television brand.
     * @return Television brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Private setter for Television brand.
     * @param brand Television brand
     */
    private void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for Television volume.
     * @return Television volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Setter for Television volume.
     * @param volume Current Television volume
     */
    public void setVolume(int volume) throws IllegalVolumeAssignmentException {
        if(volume < MIN_VOLUME || volume > MAX_VOLUME) {
            throw new IllegalVolumeAssignmentException("volume must be between " +
                    MIN_VOLUME + "  and " + MAX_VOLUME);
        }
        this.volume = volume;
    }

    /**
     * Getter for current Television channel.
     * @return Current Television channel
     */
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    /**
     * Setter for current Television channel.
     * @param channel Current Television channel
     */
    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    /**
     * Setter for Television display type
     * @param displayType Television display type
     */
    private void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    /**
     * Getter for Television display type
     * @return Television display type
     */
    public DisplayType getDisplayType() {
        return displayType;
    }

    // overrides

    /**
     * toString() override for the Television Class
     * @return String representation of Television instance
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": brand='" + this.getBrand() + '\'' +
                ", volume=" + this.getVolume() +
                ", current channel=" + this.tuner.getChannel() +
                ", display type=" + getDisplayType();
    }

    /**
     * .equals() override for Television Class
     * @param o Object for equality comparison
     * @return true if equal, false if not equal
     */
    @Override
    public boolean equals(Object o) {
        boolean areEqual;
        if (this == o) {
            areEqual = true;
        } else if (!(o instanceof Television)) {
            areEqual = false;
        } else {
            Television that = (Television) o;
            if (this.hashCode() != that.hashCode()) {
                areEqual = false;
            } else {
                areEqual = getVolume() == that.getVolume() &&
                        Objects.equals(this.getBrand(), that.getBrand()) &&
                        Objects.equals(this.getDisplayType(), that.getDisplayType()) &&
                        this.tuner.equals(that.tuner);
            }
        }
        return areEqual;
    }

    /**
     * hashCode() override for Television Class
     * @return hashcode of Television instance variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume(), this.tuner, getDisplayType());
    }

    /**
     * compareTo() override for the Television Class
     * @param o Object for comparison
     * @return positive if greater, negative if less than, zero if equal
     */
    @Override
    public int compareTo(Television o) {
        return this.getBrand().compareTo(o.getBrand());
    }
}
