package com.Dhia.moviecatalogservice.controller;


import com.Dhia.moviecatalogservice.models.Catalog;
import com.Dhia.moviecatalogservice.models.Movie;
import com.Dhia.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {


    @RequestMapping("/{userId}")
    public List<Catalog> getCatalog(@PathVariable("userId") String userId){

        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating("gwer","1"),
                new Rating("ager","2"),
                new Rating("dsga","3")
        );
        return ratings.stream().map(rating -> {
                Movie movie = restTemplate.getForObject("http://localhost:8082/movies/dhia", Movie.class);
                return new Catalog(movie.getName(),"test", 4);
                })
                .collect(Collectors.toList());
    }

}
