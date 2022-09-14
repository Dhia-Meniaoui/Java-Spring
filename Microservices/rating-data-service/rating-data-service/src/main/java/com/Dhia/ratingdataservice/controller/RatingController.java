package com.Dhia.ratingdataservice.controller;

import com.Dhia.ratingdataservice.models.Rating;
import com.Dhia.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @RequestMapping("/{userId}")
    public Rating getRating(@PathVariable("userId") String userId){
        return new Rating("test rating", "54");
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUsersRating(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("gwer","1"),
                new Rating("ager","2"),
                new Rating("dsga","3")
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
