package DataStructures;

import java.util.ArrayList;

import entity_package.Credits;
import entity_package.Movie;

public class Sorting {
	/**
	 * bubble sort on list of movies
	 * @param arrayList
	 * @param searchId
	 */
	public static void bubbleSortMovies(ArrayList<Movie> arrayList) {
		//outer loop
		for(int outer = 0; outer < arrayList.size(); outer++) {
			//inner loop
			for(int inner = 0; inner < arrayList.size() - outer - 1; inner++) {
				//check of current value is greater then the value at next index
				if(arrayList.get(inner).getId() >= arrayList.get(inner +1).getId()) {
					//swap value at index inner and inner + 1
					Movie temp = arrayList.get(inner);
					arrayList.set(inner, arrayList.get(inner + 1));
					arrayList.set(inner + 1, temp);
				}
			}
		}
	}
	
	/**
	 * bubble sort on credits list
	 * @param arrayList
	 * @param searchId
	 * @return ArrayList<Credits> SORTED LIST Of Credits
	 */
	public static void bubbleSortCredits(ArrayList<Credits> arrayList) {
		//outer loop
			for(int outer = 0; outer < arrayList.size(); outer++) {
				//inner loop
				for(int inner = 0; inner < (arrayList.size() - 1) - outer; inner++) {
					//check of current value is greater then the value at next index
					if(arrayList.get(inner).getId() > arrayList.get(inner +1).getId()) {
						//swap value at index inner and inner + 1
						Credits temp = arrayList.get(inner);
						arrayList.set(inner, arrayList.get(inner + 1));
						arrayList.set(inner + 1, temp);
					}
				}
			}
	}
	
	/**
	 * 
	 * @param arrayList
	 * @param searchId
	 */
	public static void smartBubbleSortMovies(ArrayList<Movie> arrayList) {
		//outer loop
		for(int outer = 0; outer < arrayList.size(); outer++) {
			//inner loop
			boolean isSwap = false;//flag to check swaping
			for(int inner = 0; inner < (arrayList.size() - 1) - outer; inner++) {
				//check of current value is greater then the value at next index
				if(arrayList.get(inner).getId() > arrayList.get(inner +1).getId()) {
					//swap value at index inner and inner + 1
					Movie temp = arrayList.get(inner);
					arrayList.set(inner, arrayList.get(inner + 1));
					arrayList.set(inner + 1, temp);
					isSwap  = true;
				}
			}
			
			if(!isSwap) {//if is swap is false it means array has been sorted befor completing iterations
				return;
			}
		}
	}
	
	/**
	 * 
	 * @param arrayList
	 * @param searchId
	 */
	public static void smartBubbleSortCredits(ArrayList<Credits> arrayList) {
		//outer loop
		for(int outer = 0; outer < arrayList.size(); outer++) {
			//inner loop
			boolean isSwap = false;//flag to check swaping
			for(int inner = 0; inner < (arrayList.size() - 1) - outer; inner++) {
				//check of current value is greater then the value at next index
				if(arrayList.get(inner).getId() > arrayList.get(inner +1).getId()) {
					//swap value at index inner and inner + 1
					Credits temp = arrayList.get(inner);
					arrayList.set(inner, arrayList.get(inner + 1));
					arrayList.set(inner + 1, temp);
					isSwap  = true;
				}
			}
			
			if(!isSwap) {//if is swap is false it means array has been sorted befor completing iterations
				return;
			}
		}
	}
	
	/**
	 * insert sort on credits
	 * @param arrayList
	 * @param searchId
	 */
	public static void insertSortCredits(ArrayList<Credits> arrayList) {
		//outer loop
		for(int outer = 1; outer < arrayList.size(); outer++) {
			//inner loop
			for(int inner = outer; inner > 0; inner--) {
				//check of current value is greater then the value at next index
				if(arrayList.get(inner).getId() > arrayList.get(inner - 1).getId()) {
					//swap value at index inner and inner + 1
					Credits temp = arrayList.get(inner);
					arrayList.set(inner, arrayList.get(inner - 1));
					arrayList.set(inner - 1, temp);
				}
			}
		}
	}
	
	/**
	 * insert sort on movies
	 * @param arrayList
	 */
	public static void insertSortMovies(ArrayList<Movie> arrayList) {
		//outer loop
		for(int outer = 1; outer < arrayList.size(); outer++) {
			//inner loop
			for(int inner = outer; inner > 0; inner--) {
				//check of current value is greater then the value at next index
				if(arrayList.get(inner).getId() > arrayList.get(inner - 1).getId()) {
					//swap value at index inner and inner + 1
					Movie temp = arrayList.get(inner);
					arrayList.set(inner, arrayList.get(inner - 1));
					arrayList.set(inner - 1, temp);
				}
			}
		}
	}
	
	
	////////quick sort movies /////////////////////////////
	
	/**
	 * visible method to call quic sort on movies list
	 * @param val
	 */
	public void QuickSortMovie(ArrayList<Movie> val){
       _QuickSortMovie(val, 0, val.size() - 1);
    }
	
	
	/**
	 * starting sorting of array list 
	 * @param val
	 * @param left
	 * @param right
	 */
	private void _QuickSortMovie(ArrayList<Movie> val,int left,int right){
        if(left<right){//checking left < right condition
        	//by using divide and conquere rule find pivot and call
        	//recursively with new right and left with respect to piviot
            int pivot = findpivotMovie(val,left,right);
            _QuickSortMovie(val,left,pivot-1);//recursive call for left portion of list from pivit
            _QuickSortMovie(val,pivot+1,right);//recursive call for right portion of list from pivot
        }
    }
    
    private int findpivotMovie(ArrayList<Movie> val,int left,int right){
        int pivot = left;//set pivot to left at start
        while(left<right){
         if( pivot == left){ //if pivot is equal to left
                    if(val.get(pivot).getId() <= val.get(right).getId()){//when pivot is equal to left, decrement right
                        right--;
                    }

                    else{//in not smaller replace values and set pivot ot right
                    	//swap values on right and left index
                    	Movie temp = val.get(left);
                    	val.set(left, val.get(right));
                    	val.set(right, temp);
                        pivot = right;//update povot to right 
                    }
         }
            
         else if(pivot == right){   //if piviot is equal to right
                    if(val.get(pivot).getId() >= val.get(left).getId()){//when pivote is equal to right, increment in left
                        left++;
                    }

                    else{//in pivot is not greater the left swap right and left and set pivot ot left
                    	Movie temp = val.get(left);
                    	val.set(left, val.get(right));
                    	val.set(right, temp);
                        pivot = left;//set pivot to left
                    }
         } 
       } 
        return pivot;
    }
    
    /**
	 * visible method to call quic sort on credits array list
	 * @param val
	 */
	public void QuickSortCredits(ArrayList<Movie> val){
       _QuickSortMovie(val, 0, val.size() - 1);
    }
	
	
	/**
	 * starting sorting of array list 
	 * @param val
	 * @param left
	 * @param right
	 */
	private void _QuickSortCredits(ArrayList<Credits> val,int left,int right){
        if(left<right){//checking left < right condition
        	//by using divide and conquere rule find pivot and call
        	//recursively with new right and left with respect to piviot
            int pivot = findpivotCredits(val,left,right);
            _QuickSortCredits(val,left,pivot-1);//recursive call for left portion of list from pivit
            _QuickSortCredits(val,pivot+1,right);//recursive call for right portion of list from pivot
        }
    }
    
    private int findpivotCredits(ArrayList<Credits> val, int left,int right){
        int pivot = left;//set pivot to left at start
        while(left<right){
         if( pivot == left){ //if pivot is equal to left
                    if(val.get(pivot).getId() <= val.get(right).getId()){//when pivot is equal to left, decrement right
                        right--;
                    }

                    else{//in not smaller replace values and set pivot ot right
                    	//swap values on right and left index
                    	Credits temp = val.get(left);
                    	val.set(left, val.get(right));
                    	val.set(right, temp);
                        pivot = right;//update povot to right 
                    }
         }
            
         else if(pivot == right){   //if piviot is equal to right
                    if(val.get(pivot).getId() >= val.get(left).getId()){//when pivote is equal to right, increment in left
                        left++;
                    }

                    else{//in pivot is not greater the left swap right and left and set pivot ot left
                    	Credits temp = val.get(left);
                    	val.set(left, val.get(right));
                    	val.set(right, temp);
                        pivot = left;//set pivot to left
                    }
         } 
       } 
        return pivot;
    }
}
