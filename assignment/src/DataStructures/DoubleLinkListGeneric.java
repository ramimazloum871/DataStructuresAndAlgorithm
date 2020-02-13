package DataStructures;

/**
 *
 * @author
 * @param <t>
 */
public class DoubleLinkListGeneric <t extends Comparable <t>> {
	private node start;
	private node last;
	private node current;
	boolean found = false;
	int count = 0;

	/**
	 * default constructor
	 */
	DoubleLinkListGeneric(){

	}
	/*
	 * inner class to hold data and links
	 */
	private class node{
		protected t item;
		protected node back,next;

		node(t item,node back,node next){
			this.item = item;
			this.back = back;
			this.next = next;
		}  
	}

	/**
	 * addto front of double linklist
	 * @param item
	 */
	public void addToFront(t item){
		if(start==null){
			node temp  = new node(item,null,null); 
			start = temp;
			last = temp;
		}

		else{
			start= new node(item,null,start);
			start.next.back= start;
		}       
	}

	/**
	 * add to end of double linklist
	 * @param item
	 */
	public void addToEnd(t item){
		if(last == null)
			this.addToFront(item);

		else{
			last = new node(item,last,null);
			last.back.next=last;
		}
	}

	/**
	 * finding value in double linklist
	 * @param key
	 * @return
	 */
	public boolean find(t key){
		current = null;
		if(start == null){
			System.out.println("List is empty");          
			return found = false;
		}

		else{
			current = start;
			while(current.next!= null){
				if(current.item.compareTo(key)<0)
					current = current.next;

				else
					break;
			}

			if(current.item.compareTo(key)==0)
				return found = true;

			else
				return found;  
		}      
	}

	/**
	 * deleting value form front double linklist
	 */
	public void deleteFromFront(){
		if(start==null)
			return;

		start = start.next;
		start.back = null;
	}

	/**
	 * delete form end
	 */
	public void deleteFromEnd(){
		if(start==null)
			return;

		last = last.back;
		last.next = null;
	}

	/**
	 * function to find item in double link list
	 * @param item
	 * @return
	 */
	public boolean findItem(t item){
		current = start;
		while(current!=null){
			if(current.item.compareTo(item)==0)
				return true;

			current = current.next;

		}
		return false;
	}

}
