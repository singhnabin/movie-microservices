package com.technova.moviedb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDB {
    public int page;
    public List<Result> results;
    public int total_pages;
    public int total_results;

    public @Data static class Result {
                public String original_language;
                public String original_title;
                public String poster_path;
                public boolean video;
                public double vote_average;
                public String overview;
                public String release_date;
                public int vote_count;
                public String title;
                public boolean adult;
                public String backdrop_path;
                public int id;
                public List<Integer> genre_ids;
                public double popularity;
                public String media_type;
    }


}
