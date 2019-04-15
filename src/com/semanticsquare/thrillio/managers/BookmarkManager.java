package com.semanticsquare.thrillio.managers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;
import com.semanticsquare.thrillio.util.HttpConnect;
import com.semanticsquare.thrillio.util.IOUtil;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	// singleton
	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genere, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirestors(directors);
		movie.setGenere(genere);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public WebLink createWeblink(long id, String title, String url, String host) {
		WebLink webLink = new WebLink();
		webLink.setId(id);
		webLink.setTitle(title);
		webLink.setUrl(url);
		webLink.setHost(host);

		return webLink;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors,
			String genere, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genere);
		book.setAmazonRating(amazonRating);

		return book;

	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		dao.saveUserBookmark(userBookmark);
		
		if(bookmark instanceof WebLink) {
			try {
				String url =((WebLink)bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
					if(webpage != null) {
						IOUtil.write(webpage, bookmark.getId());
					}
				}
			}catch(MalformedURLException e) {
				e.printStackTrace();
			}catch(URISyntaxException e) {
				e.printStackTrace();
			}
		}
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", " + bookmark + ", Marked by: "
				+ user.getEmail() + ", " + bookmark);

	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: ");
		if(bookmark instanceof Book){
			System.out.println(((Book)bookmark).getItemData());
		}else if (bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());
		}
		
		
	}

}
