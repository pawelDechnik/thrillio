package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.semanticsquare.thrillio.constans.BookGenere;
import com.semanticsquare.thrillio.partner.Shareable;

public class Book extends Bookmark implements Shareable{
	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(genre.equals(BookGenere.SELF_HElP) || genre.equals(BookGenere.Philosophy));
		return false;
	}

	@Override
	public String getItemData() {
		 StringBuilder builder=new StringBuilder();
		 builder.append("<item>");
		 	builder.append("<type>Book</type>");
		 	builder.append("<title>").append(getTitle()).append("</title>");
		 	builder.append("<authors>").append(StringUtils.join(authors, ",")).append("</authotrs>");
		 	builder.append("<publisher>").append(getPublisher()).append("</publisher>");
		 	builder.append("<publicationYear>").append(getPublicationYear()).append("</publicationYear>");
		 	builder.append("<genere>").append(genre).append("</genere>");
		 	builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		 builder.append("</item>");
		return builder.toString();
	}

}
