/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import java.sql.Date;
import java.util.Objects;

/**
 * An item for sale in the JavaTunes catalog.
 * The 'id' property is treated as a "primary key:"
 *  - equals() and hashCode() are both based solely on id.
 *  - Comparable is based on id, also -> natural order defined by increasing id.
 */
public class MusicItem implements Comparable<MusicItem> {
	// private class constant
	private static final double MIN_PRICE = 0.0;

	// instance variables
	private final Long id;
	private final String title;
	private final String artist;
	private final Date releaseDate;
	private Double price;
	private final MusicCategory musicCategory;

	/**
	 * MusicItem Builder inner class for object construction
	 */
	public static class Builder {
		private final Long id;
		private String title;
		private String artist;
		private Date releaseDate;
		private Double price;
		private MusicCategory musicCategory;
		private boolean inCatalog;

		/**
		 * Builder constructor to set id to next id in catalog
		 */
		public Builder(long id) {
			this.id = id;
		}

		/**
		 * Setter for Builder title
		 * @param title Builder title
		 * @return reference to the Builder
		 */
		public Builder title(String title) {
			this.title = title;
			return this;
		}

		/**
		 * Setter for Builder artist
		 * @param artist Builder artist
		 * @return reference to the Builder
		 */
		public Builder artist(String artist) {
			this.artist = artist;
			return this;
		}

		/**
		 * Setter for Builder release date
		 * @param releaseDate Builder release date
		 * @return reference to the Builder
		 */
		public Builder releaseDate(String releaseDate) {
			this.releaseDate = Date.valueOf(releaseDate);
			return this;
		}

		/**
		 * Setter for Builder price
		 * @param price Builder price
		 * @return reference to the Builder
		 * @throws IllegalPriceException price must be greater than MIN_PRICE
		 */
		public Builder price(Double price) throws IllegalPriceException {
			if(price < MIN_PRICE) {
				throw new IllegalPriceException("price must be greater than " +
						MIN_PRICE);
			}
			this.price = price;
			return this;
		}

		/**
		 * Setter for Builder music category
		 * @param musicCategory Builder music category
		 * @return reference to the Builder
		 */
		public Builder musicCategory(MusicCategory musicCategory) {
			this.musicCategory = musicCategory;
			return this;
		}

		/**
		 * Setter for determining if item is in catalog or not
		 * @param inCatalog boolean for determining if MusicItem in catalog or not
		 * @return reference to this Builder instance
		 */
		public Builder inCatalog(boolean inCatalog) {
			this.inCatalog = inCatalog;
			return this;
		}

		/**
		 * Builder build method for instantiating new MusicItem from Builder
		 * @return new MusicItem
		 */
		public MusicItem build() {
			return new MusicItem(this);
		}
	}

	// Constructors

	/**
	 * MusicItem constructor
	 * @param builder MusicItem Builder
	 */
	private MusicItem(Builder builder) {
		id = builder.id;
		title = builder.title;
		artist = builder.artist;
		releaseDate = builder.releaseDate;
		price = builder.price;
		musicCategory = builder.musicCategory;
		if(!builder.inCatalog) {
			addToCatalog(this);
		}
	}

	// buisness methods

	/**
	 * Method to add MusicItem to catalog.
	 * @param musicItem MusicItem to be added to catalog
	 */
	private void addToCatalog(MusicItem musicItem) {
		InMemoryCatalog.catalogData.put(musicItem.id, musicItem);
	}

	// Getters and setters

	/**
	 * Getter for MusicItem id
	 * @return MusicItem id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter for MusicItem title
	 * @return MusicItem title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Getter for MusicItem artist
	 * @return MusicItem artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Getter for MusicItem release date
	 * @return MusicItem release date
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Getter for MusicItem price
	 * @return MusicItem price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Setter for MusicItem price
	 * @param price MusicItem price
	 * @throws IllegalPriceException price must be greater than MIN_PRICE
	 */
	public void setPrice(Double price) throws IllegalPriceException {
		if(price < MIN_PRICE) {
			throw new IllegalPriceException("price must be greater than " +
					MIN_PRICE);
		}
		this.price = price;
	  }

	/**
	 * Getter for MusicItem category
	 * @return MusicItem category
	 */
	public MusicCategory getMusicCategory() {
    	return musicCategory;
  	}

  	// Overrides

	/**
	 * equals() override for MusicItem
	 * @param o Object for equality comparison
	 * @return true if equal, false if not
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MusicItem)) return false;
		MusicItem musicItem = (MusicItem) o;
		return getId().equals(musicItem.getId()) &&
				Objects.equals(getTitle(), musicItem.getTitle()) &&
				Objects.equals(getArtist(), musicItem.getArtist()) &&
				Objects.equals(getReleaseDate(), musicItem.getReleaseDate()) &&
				Objects.equals(getPrice(), musicItem.getPrice()) &&
				getMusicCategory() == musicItem.getMusicCategory();
	}

	/**
	 * hashCode() override for MusicItem
	 * @return hash of MusicItem instance variables
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTitle(), getArtist(), getReleaseDate(), getPrice(), getMusicCategory());
	}

	/**
	 * compareTo() override for MusicItem
	 * @param other MusicItem for comparison
	 * @return negative if this less than other, zero if equal, positive if this greater than other
	 */
	@Override
  	public int compareTo(MusicItem other) {
    	return this.getId().compareTo(other.getId());
  	}

	/**
	 * toString() override for MusicItem
	 * @return String representation of MusicItem instance
	 */
  	@Override
	public String toString() {
		return getClass().getSimpleName() + " (id=" + id + ", title=" + title + ", artist=" + artist + 
		  ", releaseDate=" + releaseDate + ", price=" + price	+ ", musicCategory=" + musicCategory + ")";
	}
}