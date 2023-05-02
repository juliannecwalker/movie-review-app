package com.example.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//Repository layer actually talks to the database
// Have to let it know what type of Object and what type of Id we are dealing with
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
    // Can form dynamic queries like this using any property name in model class as long as they are unique
    Optional<Movie> findMovieByImdbId(String imdbId);
}
