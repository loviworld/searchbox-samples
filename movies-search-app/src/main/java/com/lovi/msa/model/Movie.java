package com.lovi.msa.model;

import com.lovi.searchbox.annotation.Id;
import com.lovi.searchbox.annotation.Index;

public class Movie {
	
	@Id
	@Index
	private int id;
	
	@Index
	private String title;
	
	@Index
	private String director;
	
	@Index
	private String genres;
	
	@Index
	private String mainActor;

	private int duration;
	
	private int year;
	
	@Index
	private double imdbScore;

	public Movie() {
	}
	
	public Movie(int id, String title, String director, String genres, String mainActor, int duration, int year,
			double imdbScore) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genres = genres;
		this.mainActor = mainActor;
		this.duration = duration;
		this.year = year;
		this.imdbScore = imdbScore;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getImdbScore() {
		return imdbScore;
	}

	public void setImdbScore(double imdbScore) {
		this.imdbScore = imdbScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
