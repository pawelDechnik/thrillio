package com.sematicsquare.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.entities.WebLink;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class WeblinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//test1
		WebLink webLink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "http://www.javaworld.com");
		
		boolean isKidFriendlyEligible =webLink.isKidFriendlyEligible();
		assertFalse("For porn in url -isKid FriendlyEligible() mus return false",isKidFriendlyEligible);
		
		//test 2
		webLink=BookmarkManager.getInstance().createWeblink(2000, "Taming Porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--tiger-2.html", "http://www.javaworld.com");
		
		isKidFriendlyEligible =webLink.isKidFriendlyEligible();
		assertFalse("For porn in title -isKid FriendlyEligible() mus return false",isKidFriendlyEligible);
		
		//test3
		webLink=BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-Tiger--tiger-2.html", "http://www.adult.com");
		
		isKidFriendlyEligible =webLink.isKidFriendlyEligible();
		assertFalse("For adult in host -isKid FriendlyEligible() mus return false",isKidFriendlyEligible);
		
		
	}

}
