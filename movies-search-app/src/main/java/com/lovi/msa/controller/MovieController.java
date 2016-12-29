package com.lovi.msa.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovi.msa.model.Movie;
import com.lovi.searchbox.exception.SearchBoxOperationsException;
import com.lovi.searchbox.service.SearchBoxOperations;
import com.lovi.searchbox.service.search.Page;
import com.lovi.searchbox.service.search.SearchResult;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private SearchBoxOperations searchBoxOperations;
	
	@RequestMapping
	public ResponseEntity<SearchResult<Movie>> getAll(
			@ModelAttribute Page page) throws SearchBoxOperationsException{
		
		return new ResponseEntity<SearchResult<Movie>>(searchBoxOperations.searchByFieldPattern(Movie.class, "title", "*", page), HttpStatus.OK);
	
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<SearchResult<Movie>> getById(
			@PathVariable("id") Integer id) throws SearchBoxOperationsException{
	
		return new ResponseEntity<SearchResult<Movie>>(searchBoxOperations.searchByField(Movie.class, "id", id), HttpStatus.OK);
	
	}

	@RequestMapping("/byTitle")
	public ResponseEntity<SearchResult<Movie>> byTitle(
			@ModelAttribute Movie movie
			, @ModelAttribute Page page) throws SearchBoxOperationsException{
		
		return new ResponseEntity<SearchResult<Movie>>(searchBoxOperations.searchByField(Movie.class, "title",  movie.getTitle(), page), HttpStatus.OK);
		
	}
		
	@RequestMapping("/titlePrefix")
	public ResponseEntity<SearchResult<Movie>> query(
			@RequestParam("title") String title
			, @ModelAttribute Page page) throws SearchBoxOperationsException{
	
		String queryName = "query2";
		
		Map<String, Object> parms = new HashMap<>();
		parms.put("parm_key", "title");
		parms.put("parm_value", title);
		
		return new ResponseEntity<SearchResult<Movie>>(searchBoxOperations.search(queryName, parms, page), HttpStatus.OK);
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Movie> insert(@ModelAttribute Movie movie) throws SearchBoxOperationsException{
		
		searchBoxOperations.insert(movie);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Movie> update(@ModelAttribute Movie movie) throws SearchBoxOperationsException{
		
		searchBoxOperations.update(movie);
		return new ResponseEntity<>(movie, HttpStatus.ACCEPTED);
	
	}
	
}
