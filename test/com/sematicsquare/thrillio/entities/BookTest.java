package com.sematicsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constans.BookGenere;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		//test 1
		Book book=BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenere.Philosophy, 4.3);
		boolean isKidFriendlyEligiable=book.isKidFriendlyEligible();
		assertFalse("For philosophy -IKFE return false", isKidFriendlyEligiable);
		
		//test 2
		book=BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenere.SELF_HElP, 4.3);
		isKidFriendlyEligiable=book.isKidFriendlyEligible();
		assertFalse("For self Help iskidFriendlyELigible should return false",isKidFriendlyEligiable);
		
	}

}
