package entity_package;

public class ProductionCountries {
	String iso_3166_1 = "";
	String name = "";
	/**

	 */
	public ProductionCountries(String iso_3166_1, String name) {
		super();
		this.iso_3166_1 = iso_3166_1;
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iso_3166_1 == null) ? 0 : iso_3166_1.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof ProductionCountries)) {
			return false;
		}
		ProductionCountries other = (ProductionCountries) obj;
		if (iso_3166_1 == null) {
			if (other.iso_3166_1 != null) {
				return false;
			}
		} else if (!iso_3166_1.equals(other.iso_3166_1)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	/**
	 * @return the iso_3166_1
	 */
	public String getIso_3166_1() {
		return iso_3166_1;
	}
	/**
	 * @param iso_3166_1 the iso_3166_1 to set
	 */
	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
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
	
	
	
}
