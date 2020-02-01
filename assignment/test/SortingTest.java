import DataStructures.Sorting;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    Sorting s = new Sorting();
    ArrayList<Movie>movie=new ArrayList<>();


    //because the data set is too big we decided to test only 10 values every time
    public ArrayList<Movie>movies(){
        int i=0;
        for(Movie m:moviesBTree){
            movie.add(m);
            System.out.println(m.toString());
            i++;
            if(i==10){
                break;
            }
        }
        System.out.println("\n\n");
        return movie;
    }
    @Test
    //testing bubble sort method
    public void bubbleSortMovies() {
        s.bubbleSortMovies(movies());
        for(Movie m:this.movie){
            System.out.println(m.toString());
        }
    }
    @Test
    //testing  smart bubble sort method
    public void smartBubbleSortMovies() {
        s.smartBubbleSortMovies(movies());
        for(Movie m:this.movie){
            System.out.println(m.toString());
        }
    }
    @Test
    public void insertSortMovies() {
        s.insertSortMovies(movies());
        for(Movie m:this.movie){
            System.out.println(m.toString());
        }
    }
    @Test
    public void QuickSortMovie() {
        s.QuickSortMovie(movies());
        for(Movie m:this.movie){
            System.out.println(m.toString());
        }
    }


}
