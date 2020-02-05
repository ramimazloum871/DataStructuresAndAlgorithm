import DataStructures.BinaryTreeMovies;
import DataStructures.Sorting;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMoviesTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    BinaryTreeMovies binaryTreeMovies = new BinaryTreeMovies();
    Movie movieToSearchDelete = new Movie();
    ArrayList<Movie> sortedArrayList=new ArrayList<>();

    //because the data set is too big we decided to test only 10 values every time
    public ArrayList<Movie> movies() {
        int i = 0;
        //to insert the first 10 movies from the data set
        for (Movie m : moviesBTree) {
         //   System.out.println(m.toString());
            this.movieToSearchDelete = m;
            binaryTreeMovies.add(m);
            sortedArrayList.add(m);
            i++;
            if (i == 10) {
                break;
            }
        }
       // System.out.println("\n");
        return binaryTreeMovies.toSortedArray();
    }


    public  ArrayList<Movie>sortedArrayList(){
        movies();
        Sorting sorting=new Sorting();
        sorting.QuickSortMovie(sortedArrayList);

       return sortedArrayList;
    }
    @Test
    public void binaryTreeSorting() {
        movies();
        sortedArrayList();
        assertEquals(sortedArrayList,binaryTreeMovies.toSortedArray());
        //to print the arrayList after sorting
/*        for (Movie m : binaryTreeMovies.toSortedArray()) {
            System.out.println(m.toString());
        }*/

    }
   //Search for a movie
    @Test
    public void binaryTreeSearch() {
        movies();
      //  System.out.println(this.movieToSearch.toString());
        Movie m = binaryTreeMovies.search(this.movieToSearchDelete);
        System.out.println(m.toString());
        assertEquals(this.movieToSearchDelete, m);
    }
    
    //Delete Movie from the array
    @Test
    public void binaryTreeDelete() {
        movies();
        binaryTreeMovies.delete(this.movieToSearchDelete);
        assertEquals(9.0,binaryTreeMovies.getSize());
/*        System.out.println( binaryTreeMovies.getSize());
        System.out.println(this.movieToSearch.toString());*/
  //      System.out.println( binaryTreeMovies.getSize());
      
    }


}
