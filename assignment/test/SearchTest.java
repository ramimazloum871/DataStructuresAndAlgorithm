import DataStructures.LinkListGenric;
import DataStructures.Search;
import DataStructures.Sorting;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    Search search=new Search();
    Sorting s = new Sorting();
    ArrayList<Movie>movie=new ArrayList<>();
    LinkListGenric<Movie>linkListGenricMovies=new LinkListGenric<>();
    Movie movieToSearch=new Movie();


    //because the data set is too big we decided to test only 10 values every time
    public ArrayList<Movie>movies(){
        int i=0;
        for(Movie m:moviesBTree){
            movie.add(m);
 //           System.out.println(m.toString());
            i++;
            if(i==10){
                break;
            }
        }
  //      System.out.println("\n\n");
        return movie;
    }

    //because the data set is too big we decided to test only 10 values every time this time using LinkListGenric
    public LinkListGenric<Movie>linkListGenricMovies(){
        int i=0;
        for(Movie m:moviesBTree){
            this.movieToSearch=m;
            this.linkListGenricMovies.addToEnd(m);
//            System.out.println(m.toString());
            i++;
            if(i==10){
                break;
            }
        }
  //      System.out.println("\n\n");
        return linkListGenricMovies;
    }

    @Test
    public void binarySearchMovies(){
        //first sorting the array
        s.QuickSortMovie(movies());
        // search for the movie with the ID 12
        Movie m= search.binarySearchMovies(movie,559);
        assertEquals("Movie [id=559, title=Spider-Man 3, budget=258000000, homepagehomepage=http://www.sonypictures.com/movies/spider-man3/, originalLanguage=en, originalTitle=Spider-Man 3, overview=\"The seemingly invincible Spider-Man goes up against an all-new crop of villain – including the shape-shifting Sandman. While Spider-Man’s superpowers are altered by an alien organism, his alter ego, Peter Parker, deals with nemesis Eddie Brock and also gets caught up in a love triangle., popularity=115.699814, releaseDate=2007-05-01, revenue=890871626, runtime=139, status=Released, tagline=The battle within., voteAverage=5.9, voteCount=3576]",m.toString());
  //      System.out.println(m.toString());
    }

    @Test
    public void squeuntialSearchMovie(){
        linkListGenricMovies();
        assertEquals(true,search.squeuntialSearchMovie(this.linkListGenricMovies,this.movieToSearch));
  //      System.out.println(movieToSearch.toString());
    }


}
