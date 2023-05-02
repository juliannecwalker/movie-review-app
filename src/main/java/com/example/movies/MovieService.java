package com.example.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service class is where most of the business logic will go
@Service
public class MovieService {

    // @Autowired tells the framework to instantiate MovieRepository class for us
    @Autowired
    public MovieRepository repository;
    
    public List<Movie> findAllMovies(){
        return repository.findAll();
    }

    // Optional required in case the id passed in doesn't exist
    public Optional<Movie> findMovieByImdbId(String imdbId){
        return repository.findMovieByImdbId(imdbId);
    }
}
