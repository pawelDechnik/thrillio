package com.sematicsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constans.MovieGenere;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		//test 1
		Movie movie=	BookmarkManager.getInstance().createMovie(3000, "Citizen Kane","",  1941,new String[] {"Orson Welles","Joseph Cotten"},	new String [] {"Orson Welles"}, MovieGenere.HORROR, 8.5);
		boolean isKidFriendlyEligable=movie.isKidFriendlyEligible();
		assertFalse("For horror isKidFriendlyEligable return false ", isKidFriendlyEligable);
		
		
		//test 2
		movie=BookmarkManager.getInstance().createMovie(3000, "Citizen Kane","",  1941,new String[] {"Orson Welles","Joseph Cotten"},	new String [] {"Orson Welles"}, MovieGenere.Thrillers, 8.5);
		isKidFriendlyEligable=movie.isKidFriendlyEligible();
		assertFalse("For thrillers isKidFriendlyEligable return false", isKidFriendlyEligable);
		
		
	}

}
