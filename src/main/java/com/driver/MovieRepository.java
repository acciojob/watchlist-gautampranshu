package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class MovieRepository {
    Map<String , Movie> hmMovie = new HashMap<>();
    Map<String , Director> hmDirector = new HashMap<>();

    Map<String , List<String>> hmUpdate = new HashMap<>();


//    int theSize()
//    {
//        return hmMovie.size();
//    }
    void addMovieInDB(Movie m)
    {
       hmMovie.put(m.getName() , m);
    }
    public Movie getMovieByNameFromDB(String x)
    {
       // Movie m = null;
      // if(hmMovie.containsKey(x))
          return hmMovie.get(x);
//        for(String str : hmMovie.keySet())
//        {
//            System.out.println("key: " + str + " value: " + hmMovie.get(str));
//        }
//        System.out.println(x);
//        System.out.println(hmMovie.get(x));
      // return new Movie();
    }
    void addDirectorInDB(Director d)
    {
        hmDirector.put(d.getName() , d);
    }
    Director getDirectorByNameFromDB(String x)
    {
//        if(hmDirector.containsKey(x))
            return hmDirector.get(x);
//        return new Director();
    }
    List<String> getAllMoviesFromDB()
    {
        List<String> ans = new ArrayList<>();
        for(String str : hmMovie.keySet())
        {
            //ans.add(hmMovie.get(str));
            ans.add(str);
        }
        return ans;
    }
    void pairToDB(String d , String movie)
    {
        if(hmUpdate.containsKey(d)) hmUpdate.get(d).add(movie);
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(movie);
            hmUpdate.put(d , temp);
        }
    }
    List<String> getMoviesByDirectorNameFromDB(String d)
    {
        List<String> ans = new ArrayList<>();
       if(hmUpdate.containsKey(d)) return hmUpdate.get(d);
       //return new ArrayList<>();
        return ans;
          //return hmUpdate.get(d);
    }

    void  deleteDirectorByNameFromDB(String d)
    {
        //List<String> res = new ArrayList<>();
        int size = hmUpdate.get(d).size();
        //System.out.println(size);
        for(int i = 0; i<size; i++)
        {
            hmMovie.remove(hmUpdate.get(d).get(i));
            //res.add(hmUpdate.get(d).get(i)); // res me sari movies us director ki add ho gayi
            //System.out.print(ans.get(i) + " ");
        }
        hmDirector.remove(d);
        hmUpdate.remove(d);
    }

    void deleteAllDirectorsFromDB()
    {
        List<String> res = new ArrayList<>();
        for(String str: hmUpdate.keySet())
        {
            int size = hmUpdate.get(str).size();
            for(int i = 0; i<size; i++)
                res.add(hmUpdate.get(str).get(i));
        }
        //res me sari movies sab directors ki add hogayi

        hmDirector.clear();
        hmUpdate.clear();
       int len = res.size();
       for(int i=0; i<len; i++)
       {
           hmMovie.remove(res.get(i));
       }
    }
}
