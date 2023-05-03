package com.example.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // Use template to form dynamic query
    @Autowired
    private MongoTemplate mongoTemplate;

    // Create a new review then associate that review with the movie by imdbId
    public Review createReview(String reviewBody, String imdbId){
        // insert returns the data that you just put inside your database (a Review)
        Review review = reviewRepository.insert(new Review(reviewBody));


        // We want to update the Movie to associate this review with a movie
        // match the imdbId of the movie and the review
        // each Movie contains an array of reviewIds
        // push new review into reviewIds for the right Movie
        // Update makes the update in the database
        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();
        
        return review;
    }
}
