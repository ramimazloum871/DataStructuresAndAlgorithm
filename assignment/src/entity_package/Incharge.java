package entity_package;

public class Incharge {
	private int id = -1;
	private String name = "";
	private String department = "";
	private String gender = "";
	private String job = "";
	private String credit_id = "";
	/**
	 * @param id
	 * @param name
	 * @param department
	 * @param gender
	 * @param job
	 * @param credit_id
	 */
	public Incharge(int id, String name, String department, String gender, String job, String credit_id) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.gender = gender;
		this.job = job;
		this.credit_id = credit_id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "incharges [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (department != null ? "department=" + department + ", " : "")
				+ (gender != null ? "gender=" + gender + ", " : "") + (job != null ? "job=" + job + ", " : "")
				+ (credit_id != null ? "credit_id=" + credit_id : "") + "]";
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
		if (!(obj instanceof Incharge)) {
			return false;
		}
		Incharge other = (Incharge) obj;
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
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the credit_id
	 */
	public String getCredit_id() {
		return credit_id;
	}
	/**
	 * @param credit_id the credit_id to set
	 */
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}
	
}
