package com.Dhia.moviecatalogservice.controller;


import com.Dhia.moviecatalogservice.models.Catalog;
import com.Dhia.moviecatalogservice.models.Movie;
import com.Dhia.moviecatalogservice.models.Rating;
import com.Dhia.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
    public List<Catalog> getCatalog(@PathVariable("userId") String userId){


        UserRating ratings = restTemplate.getForObject("http://localhost:8083/rating/users/dhia", UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
               Movie movie = restTemplate.getForObject("http://localhost:8082/movies/dhia", Movie.class);
                return new Catalog(movie.getName(),"test", 4);
                })
                .collect(Collectors.toList());
    }

}
