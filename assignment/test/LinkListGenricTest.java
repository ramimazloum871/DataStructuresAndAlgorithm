import DataStructures.LinkListGenric;
import csv_read_package.CSV_READ;
import entity_package.Movie;

import java.util.ArrayList;

public class LinkListGenricTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    LinkListGenric<Movie>linkListGenricMovies=new LinkListGenric<>();
    Movie movieToSearch=new Movie();

    //because the data set is too big we decided to test only 10 values every time this time using LinkListGenric
    public LinkListGenric<Movie> linkListGenricMovies(){
        int i=0;
        for(Movie m:moviesBTree){
            this.movieToSearch=m;
            this.linkListGenricMovies.addToEnd(m);
            System.out.println(m.toString());
            i++;
            if(i==10){
                break;
            }
        }
        System.out.println("\n\n");
        return linkListGenricMovies;
    }




}
