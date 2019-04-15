package com.semanticsquare.thrillio.entities;

import java.util.Arrays;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.constans.MovieGenere;

public class Movie extends Bookmark{
	private int releaseYear;
	private String[] cast;
	private String[] direstors;
	private String genere;
	private double imdbRating;
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String[] getCast() {
		return cast;
	}
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	public String[] getDirestors() {
		return direstors;
	}
	public void setDirestors(String[] direstors) {
		this.direstors = direstors;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", direstors="
				+ Arrays.toString(direstors) + ", genere=" + genere + ", imdbRating=" + imdbRating + "]";
	}
	@Override
	public boolean isKidFriendlyEligible() {
		if(genere.equals(MovieGenere.HORROR) || genere.equals(MovieGenere.Thrillers)) {
			return false;
		}
		return true;
	}
}
