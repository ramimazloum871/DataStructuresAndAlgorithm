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
    ArrayList<Movie> sortedArrayList=new ArrayList<>();

    //because the data set is too big we decided to test only 10 values every time
    public ArrayList<Movie>movies(){
        int i=0;
        for(Movie m:moviesBTree){
            movie.add(m);
            sortedArrayList.add(m);
//            System.out.println(m.toString());
            i++;
            if(i==10){
                break;
            }
        }
//        System.out.println("\n\n");
        return movie;
    }

    public  ArrayList<Movie>sortedArrayList(){
        movies();
        Sorting sorting=new Sorting();
        sorting.QuickSortMovie(sortedArrayList);
        return sortedArrayList;
    }
    @Test
    //testing bubble sort method
    public void bubbleSortMovies() {
        movies();
        sortedArrayList();
        s.bubbleSortMovies(movie);
/*        for(Movie m:this.movie){
            System.out.println(m.toString());
        }*/
        assertEquals(sortedArrayList,movie);
    }
    @Test
    //testing  smart bubble sort method
    public void smartBubbleSortMovies() {
        movies();
        sortedArrayList();
        s.smartBubbleSortMovies(movie);
/*        for(Movie m:this.movie){
            System.out.println(m.toString());
        }*/
        assertEquals(sortedArrayList,movie);
    }
    @Test
    public void insertSortMovies() {
        movies();
        sortedArrayList();
        s.insertSortMovies(movie);
        s.insertSortMovies(sortedArrayList);
/*        for(Movie m:this.movie){
            System.out.println(m.toString());
        }*/
        assertEquals(sortedArrayList,movie);
    }
    @Test
    public void QuickSortMovie() {
        movies();
        sortedArrayList();
        s.QuickSortMovie(movie);
/*        for(Movie m:this.movie){
            System.out.println(m.toString());
        }*/
        assertEquals(sortedArrayList,movie);
    }


}
