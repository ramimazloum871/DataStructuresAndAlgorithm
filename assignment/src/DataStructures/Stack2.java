package DataStructures;


/**
 *
 * @author 
 * @param <t>
 */
public class Stack2<t> {
	private node start = null,current = null;// start will hold the head of stack 
	//refrence and use current for iteration
	int count = 0;//count will hold items number in stack
	
	//default constructor
	public Stack2(){
		//initalizing values with  default values
		start = null;
		current = null;
		count = 0;

	}
	
	/**
	 * class to hold values 
	 * make it inner class for better security
	 * @author ----
	 *
	 */
	private class node{
		protected t item;  //to hold data
		protected node link; //link will have the refrence of next data

		//agumented constructor 
		node(t item,node link){
			this.item = item;
			this.link = link;
		}  
	}
	
	/**
	 * method to add items to generic stack
	 * @param item
	 */
	public void push(t item){
		node  temp = new  node(item,start);//create new item
		start = temp; 
		count++;//incrase counter
	}

	/**
	 * method to show all data in generic stack
	 */
	public void showAll(){
		current = start;//assigning start to current for iteration purpose
		if(start == null){//if start is null list is empty
			System.out.println("List is empty");
			return;
		}

		//iterate over the list to print stack values
		while(true){
			if(current.link== null){
				System.out.println(current.item);
				return;
			}
			System.out.println(current.item);
			current = current.link;//move to next item in stack
		}
	}

	/**
	 * method to clear stack at once
	 */
	public void clear(){
		start.link= null;//set start to null to clear stack
	}


	/**
	 * method to get value form stack
	 * @return
	 */
	public t pop(){
		t x = null; //return value will be x
		if(start!= null){ //start should not be null
			x = start.item;
			start = start.link;
			count--;//decrement counter
		}
		return x;
	}

	/**
	 * peeking top values of stack without removing the value
	 * @return
	 */
	public t peek() {
		t x =  start.item;
		return x;
	}

	/**
	 * getting length of stack
	 * @return
	 */
	public int length() {
		return count;
	}
}
