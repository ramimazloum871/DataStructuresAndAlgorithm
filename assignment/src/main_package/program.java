package main_package;
import DataStructures.*;
import csv_read_package.CSV_READ;
import entity_package.Cast;
import entity_package.Credits;
import entity_package.Incharge;
import entity_package.Movie;

import java.util.ArrayList;

public class program {
	public static void main(String[] args) {
		System.out.println("*** reading CSV ** credits into link list ***");
		ArrayList<Credits> creditsList =	CSV_READ.readCsvBufferReaderCredits("tmdb_5000_credits.csv");
		System.out.println("***reading CSV ** credits into linklist end ***\n\n");

		System.out.println("*** reading CSV ** movies into binary tree ***");
		ArrayList<Movie> moviesBTree =	CSV_READ.readCsvBufferReaderMovie("tmdb_5000_movies.csv");
		System.out.println("*** reading CSV ** movies into binary tree end ***");
	}

}
