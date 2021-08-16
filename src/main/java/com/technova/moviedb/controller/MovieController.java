package com.technova.moviedb.controller;

import com.technova.moviedb.model.MovieDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/movie",produces = "application/json")
    public ResponseEntity<List<MovieDB.Result>> getMovie(){
        List<MovieDB.Result>  listMovie=null;
        ResponseEntity<MovieDB> trendingMovie=restTemplate.getForEntity("https://api.themoviedb.org/3/trending/all/week?api_key=e93f90574d40bb2740f95d0491cc04cc",MovieDB.class);
        if(trendingMovie.getStatusCode()==HttpStatus.OK){
            MovieDB movies=trendingMovie.getBody();
           listMovie=movies.getResults().stream().filter(movie->movie.getVote_count()>2000).collect(Collectors.toList());
        }
        return ResponseEntity.status(HttpStatus.OK).body(listMovie);
    }


}
