import DataStructures.LinkListGenric;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkListGenricTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    LinkListGenric<Movie>linkListGenricMovies=new LinkListGenric<>();
    Movie movieToSearch=new Movie();

    @Test
    //because the data set is too big we decided to test only 10 values every time this time using LinkListGenric
    public LinkListGenric<Movie> linkListGenricMovies(){
        int i=0;
        for(Movie m:moviesBTree){
            this.movieToSearch=m;
            this.linkListGenricMovies.addToEnd(m);
 //           System.out.println(m.toString());
            i++;
            if(i==10){
                break;
            }
        }
        System.out.println("\n\n");
        return linkListGenricMovies;
    }

    @Test
    public void showAllLinkListGenricMovies(){
        linkListGenricMovies();
        linkListGenricMovies.showAll();
        String info="Movie [id=209112, title=Batman v Superman: Dawn of Justice, budget=250000000, homepagehomepage=http://www.batmanvsupermandawnofjustice.com/, originalLanguage=en, originalTitle=Batman v Superman: Dawn of Justice, overview=\"Fearing the actions of a god-like Super Hero left unchecked, Gotham City’s own formidable, forceful vigilante takes on Metropolis’s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it’s ever known before., popularity=155.790452, releaseDate=2016-03-23, revenue=873260194, runtime=151, status=Released, tagline=Justice or revenge, voteAverage=5.7, voteCount=7004]";
        assertEquals(info,linkListGenricMovies.showAll());
    }

    // delete the first node for the array
    @Test
    public void deleteFromFront(){
        linkListGenricMovies();
        linkListGenricMovies.deleteFromFront();
        linkListGenricMovies.showAll();
        String info="Movie [id=209112, title=Batman v Superman: Dawn of Justice, budget=250000000, homepagehomepage=http://www.batmanvsupermandawnofjustice.com/, originalLanguage=en, originalTitle=Batman v Superman: Dawn of Justice, overview=\"Fearing the actions of a god-like Super Hero left unchecked, Gotham City’s own formidable, forceful vigilante takes on Metropolis’s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it’s ever known before., popularity=155.790452, releaseDate=2016-03-23, revenue=873260194, runtime=151, status=Released, tagline=Justice or revenge, voteAverage=5.7, voteCount=7004]";
        assertEquals(info,linkListGenricMovies.showAll());

    }

    // delete the End node for the array
    @Test
    public void deleteFromEnd(){
        linkListGenricMovies();
        linkListGenricMovies.deleteFromEnd();
        linkListGenricMovies.showAll();
        String info=  "Movie [id=767, title=Harry Potter and the Half-Blood Prince, budget=250000000, homepagehomepage=http://harrypotter.warnerbros.com/harrypotterandthehalf-bloodprince/dvd/index.html, originalLanguage=en, originalTitle=Harry Potter and the Half-Blood Prince, overview=\"As Harry begins his sixth year at Hogwarts, he discovers an old book marked as 'Property of the Half-Blood Prince', and begins to learn more about Lord Voldemort's dark past., popularity=98.885637, releaseDate=2009-07-07, revenue=933959197, runtime=153, status=Released, tagline=Dark Secrets Revealed, voteAverage=7.4, voteCount=5293]";
        assertEquals(info,linkListGenricMovies.showAll());
    }

}
