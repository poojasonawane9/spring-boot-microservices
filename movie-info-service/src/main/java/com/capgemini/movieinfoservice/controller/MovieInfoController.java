package com.capgemini.movieinfoservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.movieinfoservice.entity.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	private List<Movie> movies;
	
	public MovieInfoController() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(101,"Titanic","Released in 1998"));
		movies.add(new Movie(102,"The Matrix","Released in 1999"));
		movies.add(new Movie(103,"Avenger","Released in 2003"));
		movies.add(new Movie(104,"The Shift","Released in 2015"));
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> getMovieInfo(@PathVariable int movieId){
		
		for(Movie movie:movies) {
			if(movie.getMovieId() == movieId) 
				return new ResponseEntity<Movie>(movie,HttpStatus.OK);
			}
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		
		
	}
}

