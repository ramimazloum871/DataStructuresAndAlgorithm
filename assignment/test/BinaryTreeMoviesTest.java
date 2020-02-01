import DataStructures.BinaryTreeMovies;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMoviesTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    BinaryTreeMovies binaryTreeMovies = new BinaryTreeMovies();
    Movie movieToSearch = new Movie();


    //because the data set is too big we decided to test only 10 values every time
    public ArrayList<Movie> movies() {
        int i = 0;
        //to insert the first 10 movies from the data set
        for (Movie m : moviesBTree) {
            System.out.println(m.toString());
            this.movieToSearch = m;
            binaryTreeMovies.add(m);
            i++;
            if (i == 10) {
                break;
            }
        }
        System.out.println("\n");
        return binaryTreeMovies.toSortedArray();
    }

    @Test
    public void binaryTreeSorting() {
        movies();
        //to print the arrayList after sorting
        for (Movie m : binaryTreeMovies.toSortedArray()) {
            System.out.println(m.toString());
        }

    }
   //Search for a movie
    @Test
    public void binaryTreeSearch() {
        movies();
        System.out.println(this.movieToSearch.toString());
        Movie m = binaryTreeMovies.search(this.movieToSearch);
        System.out.println(m.toString());
        assertEquals(this.movieToSearch, m);
    }
    //Delete Movie from the array
    @Test
    public void binaryTreeDelete() {
        movies();
        System.out.println( binaryTreeMovies.getSize());
        System.out.println(this.movieToSearch.toString());
        binaryTreeMovies.delete(this.movieToSearch);
        System.out.println( binaryTreeMovies.getSize());
        assertEquals(9.0,binaryTreeMovies.getSize());
    }


}
