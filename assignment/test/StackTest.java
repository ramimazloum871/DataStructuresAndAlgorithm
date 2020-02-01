import DataStructures.Stack2;
import csv_read_package.CSV_READ;
import entity_package.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    ArrayList<Movie> moviesBTree = CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
    Stack2 stack = new Stack2();

    @Test
    public void stackPush() {
        // here we push 10 movies to the stack and then look at the first one, it should be the last input
        int j = 0;
        for (Movie m : moviesBTree) {
            stack.push(m);
            j++;
            if (j == 10) {
                break;
            }
        }
        stack.showAll();
        // System.out.println(stack.peek());
    }


    @Test
    public void peek() {
        stackPush();
        // this just to get the last movie from the array so I don;t have to create it from the scratch
        int i = 0;
        Movie movie = null;
        for (Movie m : moviesBTree) {
            movie = m;
            i++;
            if (i == 10) {
                break;
            }
        }
        // stack.showAll();
        assertEquals(movie, stack.peek());
        // System.out.println(stack.peek());
    }

    //delete the first node
    @Test
    public void pop() {
        stackPush();
        stack.pop();
        System.out.println("\n");
        stack.showAll();
    }
    // to get the length of the stack
    @Test
    public void length() {
        stackPush();
        assertEquals(10, stack.length());

    }


}
