package entity_package;

public class SpokenLanguages {
	String iso_639_1;
	String name;
	/**
	 * @param iso_639_1
	 * @param name
	 */
	public SpokenLanguages(String iso_639_1, String name) {
		super();
		this.iso_639_1 = iso_639_1;
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iso_639_1 == null) ? 0 : iso_639_1.hashCode());
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
		if (!(obj instanceof SpokenLanguages)) {
			return false;
		}
		SpokenLanguages other = (SpokenLanguages) obj;
		if (iso_639_1 == null) {
			if (other.iso_639_1 != null) {
				return false;
			}
		} else if (!iso_639_1.equals(other.iso_639_1)) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpokenLanguages [" + (iso_639_1 != null ? "iso_639_1=" + iso_639_1 + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}
	/**
	 * @return the iso_639_1
	 */
	public String getIso_639_1() {
		return iso_639_1;
	}
	/**
	 * @param iso_639_1 the iso_639_1 to set
	 */
	public void setIso_639_1(String iso_639_1) {
		this.iso_639_1 = iso_639_1;
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
