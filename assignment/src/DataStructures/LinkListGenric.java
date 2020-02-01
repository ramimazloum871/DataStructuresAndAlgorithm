package DataStructures;

import java.util.ArrayList;

/**
 *

 * @param <t>
 */
public class LinkListGenric<t> {
	private node start = null,current = null,previous = null;
	int count = 0;
	public LinkListGenric(){

	}
	private class node{
		protected t item;
		protected node link;

		node(t item,node link){
			this.item = item;
			this.link = link;
		}  
	}
	
	/**
	 * adding value to end
	 * @param item
	 */
	public void addToEnd(t item){
		current = start; 
		if(start == null){//adding value if list is empty
			this.addToStart(item);
			return;
		}
		while(true){//iterate over list to get end node
			if(current.link == null){
				current.link = new node(item,null);//on reached end add value to current.link
				count++;//increment counter
				return;
			}

			else
				current = current.link;// move current forward
		}
	}

	/**
	 * adding value to start 
	 * @param item
	 */
	public void addToStart(t item){
		node  temp = new  node(item,start);//make new node
		start = temp; //set star to temp 
		//increment value
		count++;
	}

	/**
	 * function to show all values in linklist
	 */
	public void showAll(){
		current = start;
		if(start == null){//handled empty list case
			System.out.println("List is empty");
			return;
		}

		while(true){//iterating over empty list
			if(current.link== null){
				System.out.println(current.item);//printing last element in list
				return;
			}
			System.out.println(current.item);//print element in list
			current = current.link;//move current to next position
		}
	}

	/**
	 * clear list
	 */
	public void clear(){
		start.link= null; //set to null 
	}

	/**
	 * function to find value 
	 * by sequential search technique
	 * @param item
	 * @return
	 */
	public boolean find(t item){
		current = start;
		previous = null;

		if(start == null)//handling empty list case
			return false;

		while(true){//iterate over list ot find value
			if(current.item.equals(item))//check if value are equal or not
				return true;//return true if equal

			if(current.link==null){//return false when you reach to end of list
				current = null;
				return false;
			}

			//moving reference forward 
			previous = current;
			current = current.link;
		}
	}

	/**
	 * add value at specfic position in linklist
	 * @param item
	 * @param position
	 */
	public void addAtPosition(t item,int position){
		current = start;
		previous = null;

		if(!(position <= count)||position <=0) //position should be smaller then count and greater or equal then 0
			return;

		else{
			if(position == 1){//if position is 1 add to start
				addToStart(item);
				return;
			}

			for(int i =1;i!= position;i++){//iterate ove list ot find position and insert the  value
				previous = current;
				current = current.link;
			}
			//updating links to add new value
			previous.link = new node(item,current);
		}
	}

	/**
	 * function to delete form fromt
	 */
	public void deleteFromFront(){
		if(start!= null){//if start is null linklist is empty
			start = start.link;//set start to start.link to delete first element
			count--;
		}
	}

	/**
	 * method to delete form end in linklist
	 */
	public void deleteFromEnd(){
		current = start;
		previous = null;

		if(start == null){//case to handle empty list 
			System.out.println("LIST IS EMPTY");
			return;
		}

		else{
			if(current.link==null&&previous == null){//if list contains only one value call function delete form front
				this.deleteFromFront();
				return;
			}
			while(true){//iterate over linklist to get last emement in current
				//and second last element in previous
				if(current.link==null){
					previous.link = current.link;//set previous.link to current.link when current reached to last
					//to delete last value
					return;
				}

				//move both current and previous to one step forward
				previous = current;
				current = current.link;
			}
		}

	} 

	/**
	 * getting count of list
	 * @return count
	 */
	public int length() {
		return count;
	}
	
	
	/**
	 * converting linklist to array list
	 * @return arraylist of t
	 */
	public ArrayList<t> toArray() {
		ArrayList<t> array = new ArrayList<t>();
		current = start;
		if(start == null){
			return null;
		}

		while(true){//iterate over linklist
			if(current.link== null){
				array.add(current.item);// add item to array list
				return array;
			}
			array.add(current.item); //add item to array list
			current = current.link;
		}
	}
}
