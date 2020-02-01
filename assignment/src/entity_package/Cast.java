package entity_package;

public class Cast {
	    private int id = -1;
	    private String name = "";
	    private int castId = -1;
	    private String character = "";
	    private String creditId = "";
	    private String gender = "";
	    private int order = -1;


		/**
		 * @param id
		 * @param name
		 * @param castId
		 * @param character
		 * @param creditId
		 * @param gender
		 * @param order
		 */
		public Cast(int id, String name, int castId, String character, String creditId, String gender, int order) {
			super();
			this.id = id;
			this.name = name;
			this.castId = castId;
			this.character = character;
			this.creditId = creditId;
			this.gender = gender;
			this.order = order;
		}

		/**
		 * @return the castId
		 */
		public int getCastId() {
			return castId;
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
		 * @return the character
		 */
		public String getCharacter() {
			return character;
		}

		/**
		 * @param character the character to set
		 */
		public void setCharacter(String character) {
			this.character = character;
		}

		/**
		 * @return the creditId
		 */
		public String getCreditId() {
			return creditId;
		}

		/**
		 * @param creditId the creditId to set
		 */
		public void setCreditId(String creditId) {
			this.creditId = creditId;
		}

		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}

		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
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
		 * @return the order
		 */
		public int getOrder() {
			return order;
		}

		/**
		 * @param order the order to set
		 */
		public void setOrder(int order) {
			this.order = order;
		}

		/**
		 * @param castId the castId to set
		 */
		public void setCastId(int castId) {
			this.castId = castId;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Cast [castId=" + castId + ", " + (name != null ? "name=" + name + ", " : "")
					+ (character != null ? "character=" + character + ", " : "")
					+ (creditId != null ? "creditId=" + creditId + ", " : "")
					+ (gender != null ? "gender=" + gender + ", " : "") + "id=" + id + ", order=" + order + "]";
		}

		
			
}
