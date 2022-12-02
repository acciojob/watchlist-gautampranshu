package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class MovieRepository {
//    Map<String , Movie> hmMovie = new HashMap<>();
//    Map<String , Director> hmDirector = new HashMap<>();
//
//    Map<String , List<String>> hmUpdate = new HashMap<>();
//
//
////    int theSize()
////    {
////        return hmMovie.size();
////    }
//    public void saveMovie(Movie m)
//    {
//       hmMovie.put(m.getName() , m);
//    }
//    public Movie findMovie(String x)
//    {
//       // Movie m = null;
//      //if(hmMovie.containsKey(x))
//          return hmMovie.get(x);
//     //  return new Movie();
//    }
//    public void saveDirector(Director d)
//    {
//        hmDirector.put(d.getName() , d);
//    }
//    public Director findDirector(String x)
//    {
//       //if(hmDirector.containsKey(x))
//            return hmDirector.get(x);
//        //return new Director();
//    }
//    public List<String> findAllMovies()
//    {
//        List<String> ans = new ArrayList<>();
//        for(String str : hmMovie.keySet())
//        {
//            //ans.add(hmMovie.get(str));
//            ans.add(str);
//        }
//        return ans;
//    }
//    public void saveMovieDirectorPair(String d , String movie)
//    {
//        if(hmUpdate.containsValue(movie)) return; //koi mil gaya ek bar hi dalni hain
//        if(hmUpdate.containsKey(d)) hmUpdate.get(d).add(movie);
//        else
//        {
//            ArrayList<String> temp = new ArrayList<>();
//            temp.add(movie);
//            hmUpdate.put(d , temp);
//        }
//    }
//    public List<String> findMoviesFromDirector(String d)
//    {
//        List<String> ans = new ArrayList<>();
//       if(hmUpdate.containsKey(d)) ans = hmUpdate.get(d);
//       //return new ArrayList<>();
//        return ans;
//          //return hmUpdate.get(d);
//    }
//
//    public void  deleteDirector(String d)
//    {
//        //List<String> res = new ArrayList<>();
//        int size = 0;
//        if(hmUpdate.containsKey(d)) size = hmUpdate.get(d).size();
//        //System.out.println(size);
//        for(int i = 0; i<size; i++)
//        {
//           if(hmMovie.containsKey(hmUpdate.get(d).get(i))) hmMovie.remove(hmUpdate.get(d).get(i));
//            //res.add(hmUpdate.get(d).get(i)); // res me sari movies us director ki add ho gayi
//            //System.out.print(ans.get(i) + " ");
//        }
//       if(hmDirector.containsKey(d)) hmDirector.remove(d);
//       if(hmUpdate.containsKey(d)) hmUpdate.remove(d);
//
//    }
//
//    public void deleteAllDirector()
//    {
//        List<String> res = new ArrayList<>();
//        for(String str: hmUpdate.keySet())
//        {
//            int size = hmUpdate.get(str).size();
//            for(int i = 0; i<size; i++)
//                res.add(hmUpdate.get(str).get(i));
//        }
//        //res me sari movies sab directors ki add hogayi
//
//        hmDirector.clear();
//        hmUpdate.clear();
//       int len = res.size();
//       for(int i=0; i<len; i++)
//       {
//           if(hmMovie.containsKey(res.get(i))) hmMovie.remove(res.get(i));
//       }
//    }
private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
        //hmMovie.put(m.getName() , m);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
       // hmDirector.put(d.getName() , d);
    }

    public void saveMovieDirectorPair(String movie, String director) {
//        List<String> currentMovies = new ArrayList<String>();
//        if (directorMovieMapping.containsKey(director)) currentMovies = directorMovieMapping.get(director);
//        currentMovies.add(movie);
//        directorMovieMapping.put(director, currentMovies);
        if(directorMovieMapping.containsValue(movie)) return; //koi mil gaya ek bar hi dalni hain
        if(directorMovieMapping.containsKey(director)) directorMovieMapping.get(director).add(movie);
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(movie);
            directorMovieMapping.put(director , temp);
        }
    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)) moviesList = directorMovieMapping.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieMapping.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        directorMap.clear();
        directorMovieMapping.clear();
    }
}
