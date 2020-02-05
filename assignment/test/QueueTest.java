import DataStructures.Queue2;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    Queue2 q = new Queue2();

    @Test
    public void enqueue() {
        // here we enqueue 10 movies to the stack and then look at the first one, it should be the last input
        int j = 0;
        for (Movie m : moviesBTree) {
            q.enqueue(m);
            j++;
            if (j == 10) {
                break;
            }
        }
    }

    @Test
    public void enqueueQueue() {
        enqueue();
        // this just to get the first movie from the array so I don;t have to create it from the scratch
        Movie movie = null;
        for (Movie m : moviesBTree) {
            movie = m;
            break;
        }
        //  q.showAll();
        assertEquals(movie, q.dequeue());
  //      System.out.println(q.dequeue());
    }
    @Test
    public void length() {
        enqueue();
      assertEquals(10, q.length());
    }
}

