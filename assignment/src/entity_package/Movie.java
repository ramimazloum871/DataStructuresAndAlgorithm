package entity_package;

import DataStructures.LinkListGenric;

import java.util.ArrayList;

public class Movie {
	/**
	 * data members of movie
	 */
	private int id = 0;
	private long budget = 0;
	private ArrayList<Genres> genres;
	private String homepagehomepage;
	private ArrayList<KeyWord> keywords;
	private String originalLanguage;
	private String originalTitle;
	private String overview;
	private String popularity;
	private ArrayList<ProductionCompanies> productionCompanies;
	private ArrayList<ProductionCountries> productionCountries;
	private String releaseDate;
	private long revenue;
	private String runtime;
	private ArrayList<SpokenLanguages> spokenLanguages;
	private String status;
	private String tagline;
	private String title;
	private float voteAverage;
	private long voteCount;
	
	
	//getter and setters of movie
	
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
	 * @return the budget
	 */
	public long getBudget() {
		return budget;
	}
	/**
	 * @param budget the budget to set
	 */
	public void setBudget(long budget) {
		this.budget = budget;
	}
	/**
	 * @return the genres
	 */
	public ArrayList<Genres> getGenres() {
		return genres;
	}
	/**
	 * @param genres the genres to set
	 */
	public void setGenres(ArrayList<Genres> genres) {
		this.genres = genres;
	}
	/**
	 * @return the homepagehomepage
	 */
	public String getHomepagehomepage() {
		return homepagehomepage;
	}
	/**
	 * @param homepagehomepage the homepagehomepage to set
	 */
	public void setHomepagehomepage(String homepagehomepage) {
		this.homepagehomepage = homepagehomepage;
	}
	/**
	 * @return the keywords
	 */
	public ArrayList<KeyWord> getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(ArrayList<KeyWord> keywords) {
		this.keywords = keywords;
	}
	/**
	 * @return the originalLanguage
	 */
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	/**
	 * @param originalLanguage the originalLanguage to set
	 */
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}
	/**
	 * @param originalTitle the originalTitle to set
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	/**
	 * @return the overview
	 */
	public String getOverview() {
		return overview;
	}
	/**
	 * @param overview the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}
	/**
	 * @return the popularity
	 */
	public String getPopularity() {
		return popularity;
	}
	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	/**
	 * @return the productionCompanies
	 */
	public ArrayList<ProductionCompanies> getProductionCompanies() {
		return productionCompanies;
	}
	/**
	 * @param productionCompanies the productionCompanies to set
	 */
	public void setProductionCompanies(ArrayList<ProductionCompanies> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}
	/**
	 * @return the productionCountries
	 */
	public ArrayList<ProductionCountries> getProductionCountries() {
		return productionCountries;
	}
	/**
	 * @param productionCountries the productionCountries to set
	 */
	public void setProductionCountries(ArrayList<ProductionCountries> productionCountries) {
		this.productionCountries = productionCountries;
	}
	/**
	 * @return the releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * @return the spokenLanguages
	 */
	public ArrayList<SpokenLanguages> getSpokenLanguages() {
		return spokenLanguages;
	}
	/**
	 * @param spokenLanguages the spokenLanguages to set
	 */
	public void setSpokenLanguages(ArrayList<SpokenLanguages> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}
	/**
	 * @return the voteAverage
	 */
	public float getVoteAverage() {
		return voteAverage;
	}
	/**
	 * @param voteAverage the voteAverage to set
	 */
	public void setVoteAverage(float voteAverage) {
		this.voteAverage = voteAverage;
	}
	/**
	 * @return the voteCount
	 */
	public long getVoteCount() {
		return voteCount;
	}
	/**
	 * @param voteCount the voteCount to set
	 */
	public void setVoteCount(long voteCount) {
		this.voteCount = voteCount;
	}
	/**
	 * @return the production_countries
	 */
	public ArrayList<ProductionCountries> getProduction_countries() {
		return productionCountries;
	}
	/**
	 * @param production_countries the production_countries to set
	 */
	public void setProduction_countries(ArrayList<ProductionCountries> production_countries) {
		this.productionCountries = production_countries;
	}
	
	/**
	 * @return the revenue
	 */
	public long getRevenue() {
		return revenue;
	}
	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}
	/**
	 * @return the runtime
	 */
	public String getRuntime() {
		return runtime;
	}
	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	/**
	 * @return the spoken_languages
	 */
	public ArrayList<SpokenLanguages> getSpoken_languages() {
		return spokenLanguages;
	}
	/**
	 * @param spoken_languages the spoken_languages to set
	 */
	public void setSpoken_languages(ArrayList<SpokenLanguages> spoken_languages) {
		this.spokenLanguages = spoken_languages;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the tagline
	 */
	public String getTagline() {
		return tagline;
	}
	/**
	 * @param tagline the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the vote_average
	 */
	public float getVote_average() {
		return voteAverage;
	}
	/**
	 * @param vote_average the vote_average to set
	 */
	public void setVote_average(float vote_average) {
		this.voteAverage = vote_average;
	}
	/**
	 * @return the vote_count
	 */
	public long getVote_count() {
		return voteCount;
	}
	/**
	 * @param vote_count the vote_count to set
	 */
	public void setVote_count(long vote_count) {
		this.voteCount = vote_count;
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
		if (!(obj instanceof Movie)) {
			return false;
		}
		Movie other = (Movie) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [id=" + id + ", " + (title != null ? "title=" + title + ", " : "") + "budget=" + budget + ", "
				+ (homepagehomepage != null ? "homepagehomepage=" + homepagehomepage + ", " : "")
				+ (originalLanguage != null ? "originalLanguage=" + originalLanguage + ", " : "")
				+ (originalTitle != null ? "originalTitle=" + originalTitle + ", " : "")
				+ (overview != null ? "overview=" + overview + ", " : "")
				+ (popularity != null ? "popularity=" + popularity + ", " : "")
				+ (releaseDate != null ? "releaseDate=" + releaseDate + ", " : "") + "revenue=" + revenue + ", "
				+ (runtime != null ? "runtime=" + runtime + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ (tagline != null ? "tagline=" + tagline + ", " : "") + "voteAverage=" + voteAverage + ", voteCount="
				+ voteCount + "]";
	}
	
	
	
}
