package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.conrtollers.BookmarkController;
import com.semanticsquare.thrillio.constans.KidFriendlyStatus;
import com.semanticsquare.thrillio.constans.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is brovsing items...");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecsion(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("new item marked: " + bookmark);
					}
				}
				if (user.getUserType().equals(UserType.EEDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

					// Mark as kid-friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStateDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

						}
					}

					// Sharing!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShereable = getShereDecision();
						if(isShereable) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
				}
			}
		}
		/*
		 * for(int i=0; i<DataStore.USER_BOOKMARK_LIMIT; i++) { int
		 * typeOffset=(int)(Math.random()*DataStore.USER_BOOKMARK_LIMIT); int
		 * bookmarkOffset=(int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
		 * 
		 * 
		 * Bookmark bookmark=bookmarks[typeOffset][bookmarkOffset];
		 * 
		 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
		 * 
		 * System.out.println(bookmark); }
		 */
	}

	private static boolean getShereDecision() {
		return Math.random() <0.5?true:false;
		
	}

	private static String getKidFriendlyStateDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.5 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}
	//TODO: Below methods simulate user input
	private static boolean getBookmarkDecsion(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n"+user.getEmail()+" is bookmarking"); for(int i=0;
	 * i<DataStore.USER_BOOKMARK_LIMIT; i++) { int
	 * typeOffset=(int)(Math.random()*DataStore.BOOKMARKS_TYPES_COUNT); int
	 * bookmarkOffset=(int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark=bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark); } }
	 */
}
