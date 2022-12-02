package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class MovieRepository {
    Map<String , Movie> hmMovie = new HashMap<String , Movie>();
    Map<String , Director> hmDirector = new HashMap<String , Director>();

    Map<String , List<String>> hmMapping = new HashMap<String , List<String>>();


//    int theSize()
//    {
//        return hmMovie.size();
//    }
    public void saveMovie(Movie m)
    {
       hmMovie.put(m.getName() , m);
    }
    public Movie findMovie(String x)
    {
        return hmMovie.get(x);
    }
    public void saveDirector(Director d)
    {
        hmDirector.put(d.getName() , d);
    }
    public Director findDirector(String x)
    {
            return hmDirector.get(x);
    }
    public List<String> findAllMovies()
    {
        List<String> ans = new ArrayList<>();
        for(String str : hmMovie.keySet())
        {
            //ans.add(hmMovie.get(str));
            ans.add(str);
        }
        return ans;
    }
    public void saveMovieDirectorPair(String d , String movie)
    {
        if(hmMapping.containsValue(movie)) return; //koi mil gaya ek bar hi dalni hain
        if(hmMapping.containsKey(d)) hmMapping.get(d).add(movie);
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(movie);
            hmMapping.put(d , temp);
        }
    }
    public List<String> findMoviesFromDirector(String d)
    {
        List<String> ans = new ArrayList<>();
       if(hmMapping.containsKey(d)) return hmMapping.get(d);
       //return new ArrayList<>();
        return ans;
          //return hmUpdate.get(d);
    }

    public void  deleteDirector(String d)
    {
        //List<String> res = new ArrayList<>();
        int size = 0;
        if(hmMapping.containsKey(d)) size = hmMapping.get(d).size();
        //System.out.println(size);
        for(int i = 0; i<size; i++)
        {
           if(hmMovie.containsKey(hmMapping.get(d).get(i))) hmMovie.remove(hmMapping.get(d).get(i));
            //res.add(hmUpdate.get(d).get(i)); // res me sari movies us director ki add ho gayi
            //System.out.print(ans.get(i) + " ");
        }
       if(hmDirector.containsKey(d)) hmDirector.remove(d);
       if(hmMapping.containsKey(d)) hmMapping.remove(d);

    }

    public void deleteAllDirector()
    {
        List<String> res = new ArrayList<>();
        for(String str: hmMapping.keySet())
        {
            int size = hmMapping.get(str).size();
            for(int i = 0; i<size; i++)
                res.add(hmMapping.get(str).get(i));
        }
        //res me sari movies sab directors ki add hogayi

        hmDirector.clear();
        hmMapping.clear();
       int len = res.size();
       for(int i=0; i<len; i++)
       {
           if(hmMovie.containsKey(res.get(i))) hmMovie.remove(res.get(i));
       }
    }
//private HashMap<String, Movie> movieMap;
//    private HashMap<String, Director> directorMap;
//    private HashMap<String, List<String>> directorMovieMapping;
//
//    public MovieRepository(){
//        this.movieMap = new HashMap<String, Movie>();
//        this.directorMap = new HashMap<String, Director>();
//        this.directorMovieMapping = new HashMap<String, List<String>>();
//    }
//
//    public void saveMovie(Movie movie){
//        movieMap.put(movie.getName(), movie);
//        //hmMovie.put(m.getName() , m);
//    }
//
//    public void saveDirector(Director director){
//        directorMap.put(director.getName(), director);
//       // hmDirector.put(d.getName() , d);
//    }
//
//    public void saveMovieDirectorPair(String movie, String director) {
////        List<String> currentMovies = new ArrayList<String>();
////        if (directorMovieMapping.containsKey(director)) currentMovies = directorMovieMapping.get(director);
////        currentMovies.add(movie);
////        directorMovieMapping.put(director, currentMovies);
//        if(directorMovieMapping.containsValue(movie)) return; //koi mil gaya ek bar hi dalni hain
//        if(directorMovieMapping.containsKey(director)) directorMovieMapping.get(director).add(movie);
//        else
//        {
//            ArrayList<String> temp = new ArrayList<>();
//            temp.add(movie);
//            directorMovieMapping.put(director , temp);
//        }
//    }
//
//    public Movie findMovie(String movie){
//        return movieMap.get(movie);
//        //return hmMovie.get(x);
//    }
//
//    public Director findDirector(String director){
//        return directorMap.get(director);
//        //return hmDirector.get(x);
//    }
//
//    public List<String> findMoviesFromDirector(String director){
////        List<String> moviesList = new ArrayList<String>();
////        if(directorMovieMapping.containsKey(director)) moviesList = directorMovieMapping.get(director);
////        return moviesList;
//        List<String> ans = new ArrayList<>();
//       if(directorMovieMapping.containsKey(director)) return directorMovieMapping.get(director);
//       //return new ArrayList<>();
//        return ans;
//    }
//
//    public List<String> findAllMovies(){
//      //  return new ArrayList<>(movieMap.keySet());
//        List<String> ans = new ArrayList<>();
//        for(String str : movieMap.keySet())
//        {
//            //ans.add(hmMovie.get(str));
//            ans.add(str);
//        }
//        return ans;
//    }
//
//    public void deleteDirector(String director){
////        List<String> movies = new ArrayList<String>();
////        if(directorMovieMapping.containsKey(director)){
////            movies = directorMovieMapping.get(director);
////            for(String movie: movies){
////                if(movieMap.containsKey(movie)){
////                    movieMap.remove(movie);
////                }
////            }
////
////            directorMovieMapping.remove(director);
////        }
////
////        if(directorMap.containsKey(director)){
////            directorMap.remove(director);
////        }
//        int size = 0;
//        if(directorMovieMapping.containsKey(director)) size = directorMovieMapping.get(director).size();
//        //System.out.println(size);
//        for(int i = 0; i<size; i++)
//        {
//           if(movieMap.containsKey(directorMovieMapping.get(director).get(i))) movieMap.remove(directorMovieMapping.get(director).get(i));
//            //res.add(hmUpdate.get(d).get(i)); // res me sari movies us director ki add ho gayi
//            //System.out.print(ans.get(i) + " ");
//        }
//       if(directorMap.containsKey(director)) directorMap.remove(director);
//       if(directorMovieMapping.containsKey(director)) directorMovieMapping.remove(director);
//    }
//
//    public void deleteAllDirector(){
////        HashSet<String> moviesSet = new HashSet<String>();
////
////        //directorMap = new HashMap<>();
////
////        for(String director: directorMovieMapping.keySet()){
////            for(String movie: directorMovieMapping.get(director)){
////                moviesSet.add(movie);
////            }
////        }
////
////        for(String movie: moviesSet){
////            if(movieMap.containsKey(movie)){
////                movieMap.remove(movie);
////            }
////        }
////        directorMap.clear();
////        directorMovieMapping.clear();
//        List<String> res = new ArrayList<>();
//        for(String str: directorMovieMapping.keySet())
//        {
//            int size = directorMovieMapping.get(str).size();
//            for(int i = 0; i<size; i++)
//                res.add(directorMovieMapping.get(str).get(i));
//        }
//        //res me sari movies sab directors ki add hogayi
//
//        directorMap.clear();
//        directorMovieMapping.clear();
//       int len = res.size();
//       for(int i=0; i<len; i++)
//       {
//           if(movieMap.containsKey(res.get(i))) movieMap.remove(res.get(i));
//       }
//    }
}
