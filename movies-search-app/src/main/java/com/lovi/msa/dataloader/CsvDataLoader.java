package com.lovi.msa.dataloader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lovi.msa.model.Movie;
import com.lovi.searchbox.annotation.DataLoader;
import com.lovi.searchbox.annotation.DataLoaderFunction;

@DataLoader
public class CsvDataLoader {
	
	private Logger logger = LoggerFactory.getLogger(CsvDataLoader.class);
	
	@DataLoaderFunction
    public Set<Movie> loadData() throws Exception{
		
		logger.info("loading data...");
		
		Set<Movie> movies = new HashSet<>();
		
		Resource resource = new ClassPathResource("movie_metadata.csv");
		InputStream resourceInputStream = resource.getInputStream();
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(resourceInputStream))) {
			
			int row = 0;
			String line;
			while((line = buffer.readLine()) != null){
				
				row ++;
				
				if(row == 1)
					continue;//skip 1st row
				
				String[] lineSplited = line.split(",");
				
				int id = row - 1;
				
				String title_tmp = lineSplited[0].trim();
				String title = title_tmp.substring(0, title_tmp.length() - 1);
				
				String director = lineSplited[1].trim();
				String genres = lineSplited[2].trim();
				String mainActor = lineSplited[3].trim();
				
				int duration = 0;
				try{
					duration = Integer.parseInt(lineSplited[4].trim());
				}catch(NumberFormatException e){
				}
				
				int year = 0;
				try{
					year = Integer.parseInt(lineSplited[5].trim());	
				}catch(NumberFormatException e){
				}
				
				double imdbScore = 0.0;
				try{
					imdbScore = Double.parseDouble(lineSplited[6].trim());	
				}catch(NumberFormatException e){
				}
				
				movies.add(new Movie(id, title, director, genres, mainActor, duration, year, imdbScore));
				
			}
			
        }
		
		return movies;
		
	}
	
}
