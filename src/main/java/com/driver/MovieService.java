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
    public void addMovieToDB(Movie m)
    {
        movieRepository.addMovieInDB(m);
    }

    public Movie getMovieByNameFromService(String x)
    {
        return movieRepository.getMovieByNameFromDB(x);
    }
    public void addDirectorToDB(Director d)
    {
        movieRepository.addDirectorInDB(d);
    }

    public Director getDirectorByNameFromService(String x)
    {
        return movieRepository.getDirectorByNameFromDB(x);
    }

    public List<Movie> getAllMoviesFromRepo()
    {
        return movieRepository.getAllMoviesFromDB();
    }
    public void pairToRepo(String d , String movie)
    {
        movieRepository.pairToDB(d , movie);
    }

    public List<String> getMoviesByDirectorNameFromRepo(String d)
    {
        return movieRepository.getMoviesByDirectorNameFromDB(d);
    }

    public void  deleteDirectorByNameFromRepo(String d)
    {
        movieRepository.deleteDirectorByNameFromDB(d);
    }

    public void deleteAllDirectorsFromRepo()
    {
        movieRepository.deleteAllDirectorsFromDB();
    }
}
