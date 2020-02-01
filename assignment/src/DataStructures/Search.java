package DataStructures;

import java.util.ArrayList;

import entity_package.Credits;
import entity_package.Movie;

public class Search {
	/**
	 * this function will do binary search on movies sorted list
	 * @param arrayList
	 * @param searchId
	 * @return
	 */
	public static Movie binarySearchMovies(ArrayList<Movie> arrayList, long searchId) {
		if(arrayList == null ||arrayList.size() == 0) { //check if array is valid or not
			return null;
		}
		int first = 0, end = arrayList.size() - 1;
		while(first <= end ) {
			//check of id exist of first or last index or not
			int center = ((end - first) / 2) + first;
			if(arrayList.get(center).getId() == searchId) { //check center value is equal or not
				return arrayList.get(center);
			}
			
			if(arrayList.get(center).getId() > searchId) { //if smaller move end to center
				end = center;//update end
				continue;
			}
			
			if(arrayList.get(center).getId() < searchId) {//if greater move first to center
				first = center;//update first
				continue;
			}	
		}
		return null;
	}
	
	/**
	 * this function will do binary search on credits sorted list
	 * @param arrayList
	 * @param searchId
	 * @return
	 */
	public static Credits binarySearchCredits(ArrayList<Credits> arrayList, long searchId) {
		if(arrayList == null ||arrayList.size() == 0) { //check if array is valid or not
			return null;
		}
		int first = 0, end = arrayList.size() - 1;
		while(first <= end ) {
			//check of id exist of first or last index or not
			int center = ((end - first) / 2) + first;
			if(arrayList.get(center).getId() == searchId) { //check center value is equal or not
				return arrayList.get(center);
			}
			
			if(arrayList.get(center).getId() > searchId) { //if smaller move end to center
				end = center;//update end
				continue;
			}
			
			if(arrayList.get(center).getId() < searchId) {//if greater move first to center
				first = center;//update first
				continue;
			}	
		}
		return null;//not found return null
	}
	
	/**
	 * sequential search on credits linklist
	 * @param linklistmovie
	 * @param item
	 * @return
	 */
	public static boolean squeuntialSearchMovie(LinkListGenric<Movie> linklistmovie, Movie item) {
		//check linklist find method for sequential search
		return linklistmovie.find(item);
	}
	
	/**
	 * sequential search on movies linklist
	 * @param linklistcredits
	 * @param item
	 * @return
	 */
	public static boolean squeuntialSearchCredits(LinkListGenric<Credits> linklistcredits, Credits item) {
		//check linklist find method for sequential search
		return linklistcredits.find(item);
	}
	
}
