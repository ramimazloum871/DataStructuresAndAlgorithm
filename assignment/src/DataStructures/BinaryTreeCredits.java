package DataStructures;

import java.util.ArrayList;

import entity_package.Credits;


public class BinaryTreeCredits {
	//data members
	private node root;
	private int count = 0; 
	//inner class
	private class node{
		protected node left = null;
		protected node right = null;
		protected Credits credits;

		//node inner class for making links 
		@SuppressWarnings("unused")
		node(){//default constructor

		}

		//argument constructor
		node(Credits credits, node leftChild, node rightChild){
			left =   leftChild;
			right =  rightChild;
			this.credits = credits;
		}
	}

	/**
	 * method to add credit to tree
	 * @param credits
	 */
	public void add(Credits credits){
		node current = root;
		if(current == null){//case to handle empty tree
			root = new node(credits,null,null);
			count++;
			return;
		}


		while(true){ 
			if(credits.getId() <= current.credits.getId()){ //if credit id is smaller the current credit id move to left
				if(current.left==null){//if left is null insert value to left of current
					current.left = new node(credits,null,null);
					count++;
					break;
				}  

				else{
					current = current.left;//if left is not null move current to left
				}
			}

			else if(credits.getId() > current.credits.getId()){//if credit id is greater then current credit id move to right
				if(current.right==null){// if rignt is null insert value their
					current.right = new node(credits,null,null);
					count++;
					break;
				}  

				else{
					current = current.right;//if right is not null move current to right
				}
			}     
		}//while finish
	}

	/**
	 * method to search credit in tree
	 * @param credits
	 * @return
	 */
	public node search(Credits credits){
		node current = root;
		if(root == null){//case handle for null tree
			return null;
		}

		else{
			while(current!=null){ //iterate over tree to find credit that has been passed to function
				if(credits.getId() == current.credits.getId()){//if current credit id is equal to credit we found the credit in tree
					return current;
				}

				else if(credits.getId() < current.credits.getId()){  //if  credit id is smaller then  current credit id move to left     
					current = current.left;         
				}

				else if(credits.getId() > current.credits.getId()){//if credit id is greater then current credit id move to right
					current = current.right;
				}     
			}
			return null;// return null if not found
		}
	}

	/**
	 * inorder traversal visibile function
	 */
	public void inOrder(){
		in_order(root);
		System.out.println();
	}

	/**
	 * preorder visible traversal function
	 */
	public void preOrder(){
		pre_order(root);
		System.out.println();
	}

	/**
	 * postoreder visibility traversal function
	 */
	public void postOrder(){
		post_order(root);
		System.out.println();
	}
	
	/**
	 * inorder treversal on tree 
	 * @param current
	 */
	private void in_order(node current){
		if(current == null){
			return;
		}
		//inorder traversal on tree to print sorted values
		in_order(current.left); 
		System.out.println(current.credits.getId()+ " " + current.credits.getName());
		in_order(current.right);  

	}

	/**
	 * pre order traversal on tree
	 * @param current
	 */
	private void pre_order(node current){
		if(current == null){
			return;
		}

		System.out.println(current.credits.getId()+ " " + current.credits.getName());
		pre_order(current.left);             
		pre_order(current.right);  
		//  System.out.println(current.info);
	}

	/**
	 * post order traversal on tree
	 * @param current
	 */
	private void post_order(node current){
		if(current == null){
			return;
		}

		post_order(current.left); 
		post_order(current.right);  
		System.out.println(current.credits.getId()+ " " + current.credits.getName());
		//  System.out.println(current.info);
	}
	
	
	/**
	 * visible function to get data in arraylist in sorted form;
	 * @return Sorted ArrayList of movies
	 */
	public ArrayList<Credits> toSortedArray() {
		ArrayList<Credits> arr = new ArrayList<Credits>();
		this.getSortedArray(root, arr);
		return arr;
	}
	
	/**
	 * return sorted list of arraylist
	 * @param current
	 * @param arrList
	 */
	private void getSortedArray(node current, ArrayList<Credits> arrList){
		if(current == null){
			return;
		}
		//inorder treversal for getting sorted array
		//recursively treverse tree to get data
		getSortedArray(current.left, arrList); 
		arrList.add(current.credits);//add data to array
		getSortedArray(current.right, arrList);  

	}
	
	/**
	 * visible function to get data in arraylist in sorted form;
	 * @return ArrayList of movies
	 */
	public ArrayList<Credits> toArray() {
		ArrayList<Credits> arr = new ArrayList<Credits>();
		this.getArray(root, arr);
		return arr;
	}
	
	/**
	 * return  arraylist from binary tree
	 * @param current
	 * @param arrList
	 */
	private void getArray(node current, ArrayList<Credits> arrList){
		if(current == null){
			return;
		}
		//recursively treverse tree to get data
		getArray(current.left, arrList); 
		getArray(current.right, arrList); 
		arrList.add(current.credits);//add data to array

	}
		
	
	/**
	 * return size of btree
	 * @return this.count
	 */
	public float getSize() {
		return this.count;
	}
	
	/**
	 * method to delete single credits from bst
	 * @param credits
	 */
	public void delete(Credits credits){
		node pre = null;
		node current = root;
		boolean found = false;
		if(current!=null){
			while(true){  

				//searching beforing deleting
				while(current!=null&&!found){
					if(credits.getId() == current.credits.getId()){                              
						found = true;
						break;
					}

					else if(credits.getId() < current.credits.getId()){  
						pre = current;
						current = current.left;         
					}

					else if(credits.getId() > current.credits.getId()){
						pre = current;
						current = current.right;
					}     
				}//end of searching

				//in found enter to delete
				if(found){
					//for both child null
					if(current.left==null&&current.right == null){

						if(pre.left.credits.getId() == current.credits.getId()){
							pre.left = null;
							break;
						}

						else {
							pre.right = null;
							break;
						}
					}

					//left null right exist
					else if(current.left == null&&current.right!=null){
						if(pre.left.credits.getId() == current.credits.getId()){
							pre.left = current.right;
							break;
						}

						else {
							pre.right = current.right;
							break;
						}
					}

					//when left is not null and right null
					else if(current.left != null&&current.right==null){
						if(pre.left.credits.getId() == current.credits.getId()){
							pre.left = current.left;
							break;
						}

						else {
							pre.right = current.left;
							break;
						}

					}//end of ifelse

					//it will return back to no child deletion and one child deletion
					//when both child are not
					else if(current.left!=null&&current.right!=null){
						{
							Credits datatemp;
							node temp;
							temp = current;
							pre=current;
							current = current.left; 
							while(current.right!=null){
								pre = current;
								current = current.right;
							}
							datatemp = temp.credits;
							temp.credits = current.credits;
							current.credits= datatemp;

						}
					}

				}
			}
		}
	}     
}


