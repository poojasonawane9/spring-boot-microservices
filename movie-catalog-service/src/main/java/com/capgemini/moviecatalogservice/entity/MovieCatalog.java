package com.capgemini.moviecatalogservice.entity;

public class MovieCatalog {

	private String movieName;
	private String movieDescription;
	private double movieRating;
	
	public MovieCatalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieCatalog(String movieName, String movieDescription, double movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}
	
	
}
