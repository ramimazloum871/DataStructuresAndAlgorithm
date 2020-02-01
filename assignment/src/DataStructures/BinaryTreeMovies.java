package DataStructures;

import java.util.ArrayList;

import entity_package.Movie;


public class BinaryTreeMovies {
	//data members
	private node root; 
	//inner class
	private long count = 0;
	private class node{
		protected node left = null;
		protected node right = null;
		protected Movie movie;

		//node inner class for making links 
		@SuppressWarnings("unused")
		node(){//default constructor

		}

		//argument constructor
		node(Movie movie, node leftChild, node rightChild){
			left =   leftChild;
			right =  rightChild;
			this.movie = movie;
		}
	}

	/**
	 * adding new movie to bst
	 * @param movie
	 */
	public void add(Movie movie){
		node current = root;
		if(current == null){//adding first movie if tree is empty
			root = new node(movie,null,null);
			count++;
			return;
		}


		while(true){ //iterate to find best position to insert new value in tree
			if(movie.getId() <= current.movie.getId()){//if movie id is smaller then current movie id move to left
				if(current.left==null){// if current left is null insert value to current.left
					current.left = new node(movie,null,null);
					count++;//increment counter
					break;
				}  

				else{
					current = current.left;//move to left if left is not null
				}
			}

			else if(movie.getId() > current.movie.getId()){//if movie id is greater then current movie id move to right
				if(current.right==null){// if current right is null insert value to current.right
					current.right = new node(movie,null,null);
					count++;
					break;
				}  

				else{
					current = current.right;//move to right if right is not null
				}
			}     
		}//while finish
	}

	/**
	 * searching node in tree 
	 * @param movie
	 * @return
	 */
	public Movie search(Movie movie){
		node current = root;
		if(root == null){//case handle for empty tree
			return null;
		}

		else{
			while(current!=null){ //iterate over bst to find data
				if(movie.getId() == current.movie.getId()){//input  movie id is equal to current movie id retrun currrent node
					return movie;
				}
				//if input movie id is smaller then current movie id move current to left branch
				else if(movie.getId() < current.movie.getId()){       
					current = current.left;         
				}

				//if input movie id is greaterthe current movie id move current ot right branch
				else if(movie.getId() > current.movie.getId()){
					current = current.right;
				}     
			}
			return null;
		}
	}

	public void inOrder(){
		in_order(root);
		System.out.println();
	}

	public void preOrder(){
		pre_order(root);
		System.out.println();
	}

	public void postOrder(){
		post_order(root);
		System.out.println();
	}
	
	/**
	 * inorder traversal on binary search tree
	 * @param current
	 */
	private void in_order(node current){
		if(current == null){
			return;
		}

		//inorder traversal for showing data in tree
		in_order(current.left);
		System.out.println(current.movie.getId()+" " + current.movie.getTitle());
		in_order(current.right);

	}

	/**
	 * preorder treversal of binary search tree
	 * @param current
	 */
	private void pre_order(node current){
		if(current == null){
			return;
		}
		//preorder treversal to show data
		System.out.println(current.movie.getId()+" " + current.movie.getTitle());
		pre_order(current.left);             
		pre_order(current.right);  
		//  System.out.println(current.info);
	}

	/**
	 * post order treversal on binary search tree
	 * @param current
	 */
	private void post_order(node current){
		if(current == null){
			return;
		}
		//post order treversal to show data
		post_order(current.left); 
		post_order(current.right);  
		System.out.println(current.movie.getId()+" " + current.movie.getTitle());
		//  System.out.println(current.info);
	}
	
	/**
	 * visible function to get data in arraylist in sorted form;
	 * @return Sorted ArrayList of movies
	 */
	public ArrayList<Movie> toSortedArray() {
		ArrayList<Movie> arr = new ArrayList<Movie>();
		this.getSortedArray(root, arr);
		return arr;
	}
	
	/**
	 * return sorted list of arraylist
	 * @param current
	 * @param arrList
	 */
	private void getSortedArray(node current, ArrayList<Movie> arrList){
		if(current == null){
			return;
		}
		//inorder treversal for getting sorted array
		//recursively treverse tree to get data
		getSortedArray(current.left, arrList); 
		arrList.add(current.movie);//add data to array
		getSortedArray(current.right, arrList);  

	}
	
	/**
	 * visible function to get data in arraylist in sorted form;
	 * @return ArrayList of movies
	 */
	public ArrayList<Movie> toArray() {
		ArrayList<Movie> arr = new ArrayList<Movie>();
		this.getArray(root, arr);
		return arr;
	}
	
	/**
	 * return  arraylist from binary tree
	 * @param current
	 * @param arrList
	 */
	private void getArray(node current, ArrayList<Movie> arrList){
		if(current == null){
			return;
		}
		//recursively treverse tree to get data
		getArray(current.left, arrList); 
		getArray(current.right, arrList); 
		arrList.add(current.movie);//add data to array

	}
		
	
	/**
	 * return size of btree
	 * @return this.count
	 */
	public float getSize() {
		return this.count;
	}
	
	
	/**
	 * mothod to delete node in binary search tree
	 * @param movie
	 */
	public void delete(Movie movie){
		node pre = null;
		node current = root;
		boolean found = false;
		if(current!=null){
			while(true){  
				//searching beforing deleting
				while(current != null && !found){
					if(movie.getId() == current.movie.getId()){                              
						found = true;
						break;
					}

					else if(movie.getId() < current.movie.getId()){  
						pre = current;
						current = current.left;         
					}

					else if(movie.getId() > current.movie.getId()){
						pre = current;
						current = current.right;
					}     
				}//end of searching

				//in found enter to delete
				if(found){
					//for both child null
					if(current.left==null&&current.right == null){

						if(pre.left.movie.getId() == current.movie.getId()){
							pre.left = null;
							count--;
							break;
						}

						else {
							pre.right = null;
							count--;
							break;
						}
					}

					//left null right exist
					else if(current.left == null&&current.right!=null){
						if(pre.left.movie.getId() == current.movie.getId()){
							pre.left = current.right;
							count--;
							break;
						}

						else {
							pre.right = current.right;
							count--;
							break;
						}
					}

					//when left is not null and right null
					else if(current.left != null&&current.right==null){
						if(pre.left.movie.getId() == current.movie.getId()){
							pre.left = current.left;
							count--;
							break;
						}

						else {
							pre.right = current.left;
							count--;
							break;
						}

					}//end of ifelse

					//it will return back to no child deletion and one child deletion
					//when both child are not
					else if(current.left!=null&&current.right!=null){
						{
							Movie datatemp;
							node temp;
							temp = current;
							pre=current;
							current = current.left; 
							while(current.right!=null){
								pre = current;
								current = current.right;
							}
							datatemp = temp.movie;
							temp.movie = current.movie;
							current.movie= datatemp;
							count--;
						}
					}

				}
			}
		}
	}     
}


