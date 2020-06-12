/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import java.util.*;

// OF COURSE THIS CLASS DOESN'T COMPILE
// Your first job is to fulfill the contract that this class has signed.
public class InMemoryCatalog implements Catalog {
	
	static final Map<Long, MusicItem> catalogData = new HashMap<>() {{
		try {
			long catalogSize = 0;
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Diva").
					artist("Annie Lennox").
					releaseDate("1992-01-04").
					price(13.99).
					musicCategory(MusicCategory.POP).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Dream of the Blue Turtles").
					artist("Sting").
					releaseDate("1985-02-05").
					price(14.99).
					musicCategory(MusicCategory.POP).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Trouble is...").
					artist("Kenny Wayne Shepherd Band").
					releaseDate("1997-08-08").
					price(14.99).
					musicCategory(MusicCategory.BLUES).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Lie to Me").
					artist("Jonny Lang").
					releaseDate("1997-08-26").
					price(17.97).
					musicCategory(MusicCategory.BLUES).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Little Earthquakes").
					artist("Tori Amos").
					releaseDate("1992-01-18").
					price(14.99).
					musicCategory(MusicCategory.ALTERNATIVE).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Seal").
					artist("Seal").
					releaseDate("1991-08-18").
					price(17.97).
					musicCategory(MusicCategory.POP).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Ian Moore").
					artist("Ian Moore").
					releaseDate("1993-12-05").
					price(9.97).
					musicCategory(MusicCategory.CLASSICAL).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("So Much for the Afterglow").
					artist("Everclear").
					releaseDate("1997-01-19").
					price(13.99).
					musicCategory(MusicCategory.ROCK).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Surfacing").
					artist("Sarah McLachlan").
					releaseDate("1997-12-04").
					price(17.97).
					musicCategory(MusicCategory.ALTERNATIVE).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Hysteria").
					artist("Def Leppard").
					releaseDate("1987-06-20").
					price(17.97).
					musicCategory(MusicCategory.ROCK).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("A Life of Saturdays").
					artist("Dexter Freebish").
					releaseDate("2000-12-06").
					price(16.97).
					musicCategory(MusicCategory.RAP).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Human Clay").
					artist("Creed").
					releaseDate("1999-10-21").
					price(18.97).
					musicCategory(MusicCategory.ROCK).
					inCatalog(true).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("My, I'm Large").
					artist("Bobs").
					releaseDate("1987-02-20").
					price(11.97).
					musicCategory(MusicCategory.COUNTRY).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("So").
					artist("Peter Gabriel").
					releaseDate("1986-10-03").
					price(17.97).
					musicCategory(MusicCategory.POP).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Big Ones").
					artist("Aerosmith").
					releaseDate("1994-05-08").
					price(18.97).
					musicCategory(MusicCategory.ROCK).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("90125").
					artist("Yes").
					releaseDate("1983-10-16").
					price(11.97).
					musicCategory(MusicCategory.ROCK).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("1984").
					artist("Van Halen").
					releaseDate("1984-08-19").
					price(11.97).
					musicCategory(MusicCategory.ROCK).
					inCatalog(true).
					build());
			put(++catalogSize, new MusicItem.Builder(catalogSize).
					title("Escape").
					artist("Journey").
					releaseDate("1981-02-25").
					price(11.97).
					musicCategory(MusicCategory.CLASSIC_ROCK).
					inCatalog(true).
					build());
		} catch (IllegalPriceException e) {
			e.printStackTrace();
		}
	}};

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + catalogData;
	}

	@Override
	public MusicItem findById(Long id) {
		return null;
	}

	@Override
	public Collection<MusicItem> findByKeyword(String keyword) {
		return null;
	}

	@Override
	public Collection<MusicItem> findByCategory(MusicCategory category) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Collection<MusicItem> getAll() {
		return null;
	}

	// AFTER YOU'VE SATISFIED YOUR CONTRACTUAL OBLIGATIONS ABOVE, DO THESE ADDITIONAL TASKS.
	// NOTES:

	// 0. You can tackle them in any order, each one is independent of the others.

	// 1. None of these methods should print to stdout! (the console).  Instead, return a value.
	//    Each one should be tested by client-side code
	//    (and there you *can* print your results, to verify that your code works as it should).
	//    Be smart here: don't write a single giant main() method, figure out a better way.
	//    Next week, we'll do unit testing with JUnit, but until that time, figure something else out.

	// 2. You may need to research a few things, that's to be expected.  Life Is Open-Book...
	//    The Javadoc is a good first place to look.

	// 3. Keep a lookout for redundant code.  There is a high probability that you will write a chunk
	//    of code more than once.  When you see that, you should strongly consider refactoring that
	//    repeated code into a private method, and then calling that method from where it's needed.
	//    IntelliJ helps a lot here.  Select the repeated code in question, then right-click -> Refactor ->
	//    Extract Method.
	//    It's not just about removing redundancies - it will make the more complicated methods easier to write!

	/**
	 * TASK: find all MusicItems where title is same as artist.
	 * For example, Madonna's first album is simply titled, "Madonna."
	 */


	/**
	 * TASK: find all "rock" items whose price is less than or equal to the specified price.
	 */


	/**
	 * TASK: how many items of the specified genre do we sell?
	 */


	/**
	 * TASK: determine average price of our low-cost, extensive catalog of music.
	 */


	/**
	 * TASK: find the cheapest item with the specified genre.
	 */


	/**
	 * TASK: find the average price of items in the specified genre.
	 */


	/**
	 * TASK: are all items priced at least $10?
	 * This is a yes/no answer.
	 */


	/**
	 * TASK: do we sell any items with the specified genre?
	 * Another yes/no answer.
	 */


	/**
	 * TASK: determine the titles of all "pop" items, sorted by natural order.
	 * Just the titles!
	 */


	/**
	 * TASK: find all items released in the 80s whose price is less than or equal to the specified price.
	 */


	/**
	 * TASK: return a map whose keys are all the genres (categories), and each key's associated value
	 * is a collection of items in that genre.  If there is a genre that we don't currently
	 * sell, that key's associated value should be an empty collection, not null.
	 */

}