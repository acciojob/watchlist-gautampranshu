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
private HashMap<String, Movie> hmMovie;
    private HashMap<String, Director> hmDirector;
    private HashMap<String, List<String>> hmUpdate;

    public MovieRepository(){
        this.hmMovie = new HashMap<String, Movie>();
        this.hmDirector = new HashMap<String, Director>();
        this.hmUpdate = new HashMap<String, List<String>>();
    }


//    int theSize()
//    {
//        return hmMovie.size();
//    }
    public void addMovieInDB(Movie m)
    {
       hmMovie.put(m.getName() , m);
    }
    public Movie getMovieByNameFromDB(String x)
    {
       // Movie m = null;
      //if(hmMovie.containsKey(x))
          return hmMovie.get(x);
     //  return new Movie();
    }
    public void addDirectorInDB(Director d)
    {
        hmDirector.put(d.getName() , d);
    }
    public Director getDirectorByNameFromDB(String x)
    {
       //if(hmDirector.containsKey(x))
            return hmDirector.get(x);
        //return new Director();
    }
    public List<String> getAllMoviesFromDB()
    {
        List<String> ans = new ArrayList<>();
        for(String str : hmMovie.keySet())
        {
            //ans.add(hmMovie.get(str));
            ans.add(str);
        }
        return ans;
    }
    public void pairToDB(String d , String movie)
    {
//        if(hmUpdate.containsValue(movie)) return; //koi mil gaya ek bar hi dalni hain
//        if(hmUpdate.containsKey(d)) hmUpdate.get(d).add(movie);
//        else
//        {
//            ArrayList<String> temp = new ArrayList<>();
//            temp.add(movie);
//            hmUpdate.put(d , temp);
//        }
        List<String> temp = new ArrayList<String>();
        if(hmUpdate.containsKey(d)) temp = hmUpdate.get(d);
        temp.add(movie);
        hmUpdate.put(d, temp);
    }
    public List<String> getMoviesByDirectorNameFromDB(String d)
    {
        List<String> ans = new ArrayList<>();
       if(hmUpdate.containsKey(d)) ans = hmUpdate.get(d);
       //return new ArrayList<>();
        return ans;
          //return hmUpdate.get(d);
    }

    public void  deleteDirectorByNameFromDB(String d)
    {
        //List<String> res = new ArrayList<>();
        int size = 0;
        if(hmUpdate.containsKey(d)) size = hmUpdate.get(d).size();
        //System.out.println(size);
        for(int i = 0; i<size; i++)
        {
           if(hmMovie.containsKey(hmUpdate.get(d).get(i))) hmMovie.remove(hmUpdate.get(d).get(i));
            //res.add(hmUpdate.get(d).get(i)); // res me sari movies us director ki add ho gayi
            //System.out.print(ans.get(i) + " ");
        }
       if(hmDirector.containsKey(d)) hmDirector.remove(d);
       if(hmUpdate.containsKey(d)) hmUpdate.remove(d);

//        List<String> res = new ArrayList<>();
//        if(hmUpdate.containsKey(d)){
//            res = hmUpdate.get(d);
//            for(String movie: res){
//                if(hmMovie.containsKey(movie)){
//                    hmMovie.remove(movie);
//                }
//            }
//
//            hmUpdate.remove(d);
//        }
//
//        if(hmDirector.containsKey(d)){
//            hmDirector.remove(d);
//        }
    }

    public void deleteAllDirectorsFromDB()
    {
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
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: hmUpdate.keySet()){
            for(String movie: hmUpdate.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(hmMovie.containsKey(movie)){
                hmMovie.remove(movie);
            }
        }
        hmDirector.clear();
        hmUpdate.clear();
    }
}
