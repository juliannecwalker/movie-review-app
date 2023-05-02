package com.example.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// colection refers to the collection in the database
@Document(collection = "movies")

//@Data takes care of all getters and setters
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    // Id of this movie
    @Id
    private ObjectId id;

    // All the fields of the object (from the JSON)
    private String imdb;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    // This will make the reviews a collection in the database
    @DocumentReference
    private List<Review> reviewIds;

}
