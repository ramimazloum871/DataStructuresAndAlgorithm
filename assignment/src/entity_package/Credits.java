package entity_package;

import DataStructures.LinkListGenric;

import java.util.ArrayList;

public class Credits {
	private int id = -1;
	private String name = "";
	private ArrayList<Cast> cast;
	private ArrayList<Incharge> incharges;
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param cast
	 * @param incharges
	 */
	public Credits(int id, String name, ArrayList<Cast> cast, ArrayList<entity_package.Incharge> incharges) {
		super();
		this.id = id;
		this.name = name;
		this.cast = cast;
		this.incharges = incharges;
	}
	
	


	public Credits() {
		this.id = -1;
		this.name = "";
		this.cast = null;
		this.incharges = null;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Movie [id=" + id + ", " + (name != null ? "name=" + name : "") +getCast()+" "+getIncharges().toString()+ "]";
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Credits)) {
			return false;
		}
		Credits other = (Credits) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the cast
	 */
	public ArrayList<Cast> getCast()
	{
		//System.out.println(cast);

		return cast;
	}

	/**
	 * @param cast the cast to set
	 */
	public void setCast(ArrayList<Cast> cast) {
		this.cast = cast;
	}

	/**
	 * @return the incharges
	 */
	public ArrayList<Incharge> getIncharges() {
		//System.out.println(incharges);
		return incharges;
	}




	/**
	 * @param incharges the incharges to set
	 */
	public void setIncharges(ArrayList<Incharge> incharges) {
		this.incharges = incharges;
	}
	
	

}
