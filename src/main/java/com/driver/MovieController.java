package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

//    @GetMapping("/size")
//    ResponseEntity<Integer> size()
//    {
//        return new ResponseEntity(movieService.findSize() , HttpStatus.ACCEPTED);
//    }

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie m)
    {
        movieService.addMovieToDB(m);
        return new ResponseEntity("movie is added to DataBase" , HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String x)
    {
        return new ResponseEntity(movieService.getMovieByNameFromService(x) , HttpStatus.ACCEPTED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director d)
    {
        movieService.addDirectorToDB(d);
        return new ResponseEntity("Director is added to DataBase" , HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String x)
    {
        return new ResponseEntity(movieService.getDirectorByNameFromService(x) , HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        return new ResponseEntity(movieService.getAllMoviesFromRepo() , HttpStatus.ACCEPTED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie , @RequestParam("director") String d)
    {
        movieService.pairToRepo(d , movie);
        return new ResponseEntity("movie director pair is added" , HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String d)
    {
        return new ResponseEntity(movieService.getMoviesByDirectorNameFromRepo(d) , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam("director") String d)
    {
        movieService.deleteDirectorByNameFromRepo(d);
        return new ResponseEntity("the director and all its movies are removed" , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectorsFromRepo();
        return new ResponseEntity("all directors and their movies are removed" , HttpStatus.ACCEPTED);
    }
}
