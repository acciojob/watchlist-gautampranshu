package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

//    int findSize()
//    {
//        return movieRepository.theSize();
//    }
    public void addMovieToDB(Movie m)
    {
       // movieRepository.addMovieInDB(m);
        movieRepository.saveMovie(m);
    }

    public Movie getMovieByNameFromService(String x)
    {
        return movieRepository.findMovie(x);
        //return movieRepository.getMovieByNameFromDB(x);
    }
    public void addDirectorToDB(Director d)
    {
        movieRepository.saveDirector(d);
//        movieRepository.addDirectorInDB(d);
    }

    public Director getDirectorByNameFromService(String x)
    {
        return movieRepository.findDirector(x);
//        return movieRepository.getDirectorByNameFromDB(x);
    }

    public List<String> getAllMoviesFromRepo()
    {
//        return movieRepository.getAllMoviesFromDB();
        return movieRepository.findAllMovies();
    }
    public void pairToRepo(String d , String movie)
    {
        movieRepository.saveMovieDirectorPair(d , movie);
//        movieRepository.pairToDB(d , movie);
    }

    public List<String> getMoviesByDirectorNameFromRepo(String d)
    {
//        return movieRepository.getMoviesByDirectorNameFromDB(d);
        return movieRepository.findMoviesFromDirector(d);
    }

    public void  deleteDirectorByNameFromRepo(String d)
    {
        movieRepository.deleteDirector(d);
//        movieRepository.deleteDirectorByNameFromDB(d);
    }

    public void deleteAllDirectorsFromRepo()
    {
        movieRepository.deleteAllDirector();
//        movieRepository.deleteAllDirectorsFromDB();
    }
}
