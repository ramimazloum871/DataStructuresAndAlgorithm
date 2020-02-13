package DataStructures;


/**
 * generic queue implementation
 * @author 
 * @param <t>
 */
public class Queue2<t> {
	private node start = null,current = null,previous = null;
	int count = 0;
	public Queue2(){

	}
	
	//inner class to hold data and links 
	private class node{
		protected t item;
		protected node link;

		node(t item,node link){
			this.item = item;
			this.link = link;
		}  
	}
	
	/**
	 * enqueue method to insert data to queue
	 * @param item
	 */
	public void enqueue(t item){
		node  temp = new  node(item,start);//make new object
		start = temp; //append start of root
		count++;
	}

	/**
	 * function to show all data
	 */
	public void showAll(){
		current = start;
		if(start == null){//case to handle empty list
			System.out.println("List is empty");
			return;
		}

		while(true){//iterating over data to display values
			if(current.link== null){
				System.out.println(current.item);
				return;
			}
			System.out.println(current.item);
			current = current.link;//moving to next element
		}
	}

	/**
	 * function to clear queue
	 */
	public void clear(){
		start.link= null;
	}


	/**
	 * function do dequeue single element form queue
	 */
	public t dequeue(){
		current = start;
		previous = null;

		if(start == null){//case to handle empty queue
			System.out.println("Queue is empty");
			return null;
		}

		else{
			if(current.link==null && previous == null){//dequeue handling for single element
				t x = current.item;
				current = current.link;
				return x;
			}
			while(true){//iterating over queue to delete last element
				t x = current.item;
				if(current.link==null){//if current.link is null we reached the last value
					previous.link = current.link;//previous contains the 2ns last value link 
					//so update previous.link to remove last element
					return x; //return removed value
				}

				previous = current;//move previous to current
				current = current.link;//move current to next link 
			}
		}

	} 

	/**
	 * return length of queue
	 * @return
	 */
	public int length() {
		return count;
	}
}
