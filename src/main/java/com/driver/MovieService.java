package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

//    int findSize()
//    {
//        return movieRepository.theSize();
//    }
    void addMovieToDB(Movie m)
    {
        movieRepository.addMovieInDB(m);
    }

    public Movie getMovieByNameFromService(String x)
    {
        return movieRepository.getMovieByNameFromDB(x);
    }
    void addDirectorToDB(Director d)
    {
        movieRepository.addDirectorInDB(d);
    }

    Director getDirectorByNameFromService(String x)
    {
        return movieRepository.getDirectorByNameFromDB(x);
    }

    List<String> getAllMoviesFromRepo()
    {
        return movieRepository.getAllMoviesFromDB();
    }
    void pairToRepo(String d , String movie)
    {
        movieRepository.pairToDB(d , movie);
    }

    List<String> getMoviesByDirectorNameFromRepo(String d)
    {
        return movieRepository.getMoviesByDirectorNameFromDB(d);
    }

    void  deleteDirectorByNameFromRepo(String d)
    {
        movieRepository.deleteDirectorByNameFromDB(d);
    }

    void deleteAllDirectorsFromRepo()
    {
        movieRepository.deleteAllDirectorsFromDB();
    }
}
