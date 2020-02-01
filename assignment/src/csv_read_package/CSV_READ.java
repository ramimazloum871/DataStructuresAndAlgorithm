package csv_read_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import DataStructures.BinaryTreeMovies;
import DataStructures.LinkListGenric;
import entity_package.Cast;
import entity_package.Credits;
import entity_package.Genres;
import entity_package.Incharge;
import entity_package.KeyWord;
import entity_package.Movie;
import entity_package.ProductionCompanies;
import entity_package.ProductionCountries;
import entity_package.SpokenLanguages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CSV_READ {

	/**
	 * method to retrive data for credits files
	 * @param fileName
	 * @return linklist<Credits>
	 */
	public static ArrayList<Credits> readCsvBufferReaderCredits(String fileName) {
		ArrayList<Credits> list = new ArrayList<Credits>(); //linklist of credists to store data
		JSONArray jsonArrayCast = new JSONArray(); //json array for cast value getting from file
		JSONArray jsonArrayInch = new JSONArray();//json array for incharges getting frm file
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {//initelize buffer reader with file to read data
		    String line;
		    boolean columnsRead = false;
		    Credits credits = null;
		    while ((line = br.readLine()) != null) {//iterate over the lines
		        if(!columnsRead) {//reading fields name
		        	columnsRead = true;
		        	continue;
		        }
		        String[] values = line.split(",", 2);//split the string for  , first value will be id
		        int id = Integer.parseInt(values[0]);//getting id
		        String name = values[1].split("[\",\\[]|[,\"\\[]|[,\\[]", 2)[0].replace("\"", "");//getting name by using regex
		        String cast = null;
		        String incharges = null;
		        String pattern = "(\\[.*\\]).*(\\[.*\\])";//pattern to extract  json arrays in string form, from value[1]
		        Pattern pat= Pattern.compile(pattern, Pattern.MULTILINE);//compile pattern
		        // Now create matcher object.
		        Matcher matcher = pat.matcher(values[1]);//make matcher using value[1] and pat
		        while(matcher.find()) {//find groups form search from patterns
		        	if(matcher.groupCount() > 0)
		        	   cast = matcher.group(1).replace("\"\"", "\"");//first group will be cast
		        	if(matcher.groupCount() > 1)
			           incharges = matcher.group(2).replace("\"\"", "\"");//second group will be incharge
		        }
		        try {
		        	if(cast.length() > 2)
		        	 jsonArrayCast = new JSONArray(cast);//try to cast stringify json to json
		        	if(incharges.length() > 2)
		        	 jsonArrayInch = new JSONArray(incharges);//try to cast stringify json to json
		        }catch(Exception ex) {
		        	System.err.println(ex);
		        	continue;
		        }
		        //make credit object form id, name 		       
		        //use methods parseCast and parseIncharges to get their crossponding list and pass them to reedits object
		        credits = new Credits(id, name, (jsonArrayCast.length() > 0)?CSV_READ.parseCast(jsonArrayCast):null, (jsonArrayInch.length() > 0)?CSV_READ.parseIncharge(jsonArrayInch):null);
		        list.add(credits);
		    }
		    return list;//return list
		} catch(IOException ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
	
	/**
	 * method to parse json array of casts and converting them to linklist of credits
	 * @param array JSON ARRAY OF cast data
	 * @return linklist<Credits>
	 */
	private static ArrayList<Cast> parseCast(JSONArray array) {
		ArrayList<Cast> list = new ArrayList<Cast>();
			for(int i = 0; i < array.length(); i++) {//iterate over the values of json array
				try {
					JSONObject obj =  array.getJSONObject(i);//get index value of json array
					//create cast object for obj data and add them to list
					list.add(new Cast(obj.getInt("id"), obj.getString("name"),obj.getInt("cast_id"), obj.getString("character"), obj.getString("credit_id"), (obj.getInt("gender") == 1)?"male":"female", obj.getInt("order")));
				}catch(Exception ex) {
					//System.err.println(ex);
				}
			}
		return  list; //return linklist of credits
	}
	/**
	 * method to parse json array of casts and converting them to linklist of credits
	 * @param array JSON ARRAY OF incharge data
	 * @return linklist<Incharge>
	 */
	private static ArrayList<Incharge> parseIncharge(JSONArray array) {
		ArrayList<Incharge> list = new ArrayList<Incharge>();
			for(int i = 0; i < array.length(); i++) {//iterate over items of array
				try {
					JSONObject obj =  array.getJSONObject(i);//extract single data
					//make incharge object and add them to list
					list.add(new Incharge(obj.getInt("id"), obj.getString("name"), obj.getString("department"), (obj.getInt("gender") == 1)?"male":"female", obj.getString("job"), obj.getString("credit_id")));
				}catch(Exception ex) {
					//System.err.println(ex);
				}
			}
		return  list; //return linklist of incharges
	}
	
	
////////////////////////Reading Movie csv ////////////////////////
	
	/**
	 * file to read movies from movies.csv file
	 * @param fileName
	 * @return binary search tree of movies
	 */
	public static ArrayList<Movie> readCsvBufferReaderMovie(String fileName) {
		ArrayList<Movie> bTreeMovies = new ArrayList<Movie> ();//initalize binary tree
		Map<String, String>  hash = new HashMap<String, String>();//hash map to store single record
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {//creating file read buffer
		    String line;
		    boolean columnsRead = false;
		    String[] colName = null;
		    while ((line = br.readLine()) != null) {//iterator over the file to read lines
		        if(!columnsRead) {
		        	for(String col: colName = line.split(",")){//put column to hash map with default value $
		        		hash.put(col, "$");
		        	}
		        	columnsRead = true;
		        	continue;
		        }
		        /*
		         * the logic in for loop is to extract record fields in line
		         * budget,genres,homepage,id,keywords,original_language,original_title,
		         * overview,popularity,production_companies,production_countries,release_date,
		         * revenue,runtime,spoken_languages,status,tagline,title,vote_average,
		         * vote_count 
		         * 
		         * if we encouter [ it means is is start of json array and ] means end of json array
		         *  you can see further checks in for loop 
		         *  
		         *  " is a start/end of string if isJsonArray is false
		         *  
		         *  , will break current value and if it is not a json or string
		         *  
		         */
		        boolean isJsonArray = false;
		        boolean isString = false;
		        String reader = "";
		        int columnIndex = 0;
		        //System.out.println(line);
		        int index = 0;
		        for(; index < line.length(); index++) {
//		        	if(columnIndex == 5) {
//		        		System.out.print(line.charAt(index));
//		        	}
		        	//check for start of json 
		        	if((line.charAt(index) == '[' && (index == 0 || line.charAt(index -1) == '\"' ))) {
		        		isJsonArray = true;
		        		isString = false;
		        		reader += line.charAt(index);//append cahr to reader
		        		
		        		//check for end of json
		        	} else if(line.charAt(index) == ']' && isJsonArray) {
		        		isJsonArray = false;//set isJson to false
		        		reader += line.charAt(index);//append cahr to reader
		        		hash.put(colName[columnIndex++], reader);//put it to crossponding hash value using index column
		        		reader = "";//reset reader
		        		if(index < line.length() -1 && line.charAt(index + 1) == '\"') {//if it contains " after ] ignore and increment index
		        			//System.out.print(line.charAt(index));
		        			index++;
		        		}
		        		
		        	} else if(line.charAt(index) == '\"' && !isJsonArray) {// either it will be start/end of string if it is not jsonarray
		        		if(index < line.length() -1 && line.charAt(index + 1) == '\"') {
		        			index++;
		        			continue;
		        		}
		        		isString = !isString;//toggle string status
		        		if(isString) {
		        			reader +=  line.charAt(index);//append char to reader
		        		} else {
		        			hash.put(colName[columnIndex++], reader);//on end of string put value to hash map 
			        		reader = "";//reset the reader vale
		        		}
		        	} else if(line.charAt(index) == ',' && !isString && !isJsonArray) {//break value and save to hash map and start to read new value form line
		        		if(reader.length() > 0) {//if reader length is 0
		        			hash.put(colName[columnIndex++], reader);
			        		reader = "";
		        		}
		        		//handling consective , values in line
		        		if(index < line.length() -1 && line.charAt(index + 1) == ',') {
		        			index++;
		        			columnIndex++;
		        		}
		        	} else {//if we encounter character other then [ ] " , append it to reader
		        		reader +=  line.charAt(index);
		        	}
		        	//if line ends without all values read another line form file to complete current record
		        	if(index == line.length() -1 && columnIndex < colName.length -1) {
		        		line = br.readLine();
		        		if(line != null) {
		        			index = 0;
		        		}
		        	}
		        	//System.out.print(line.charAt(index));
		        }
		        //put remaining value in reader to hash
		        if(reader.length() > 0) {
        			hash.put(colName[columnIndex++], reader);
	        		reader = "";
        		}
		        //make movie object by passing hash to parseCreditsDataHash and add it to binary tree
		       Movie movieTemp = CSV_READ.parseCreditsDataHash(hash);
		        //TODO هون لغيت الطباعة
		      // System.out.println(movieTemp);
		        bTreeMovies.add(movieTemp);
		    }
		    return bTreeMovies;
		} catch(IOException ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
	
	private static Movie parseCreditsDataHash(Map<String, String> hash) {
		Movie movie = new Movie();// create movie object
		//add values form hash to movie object
		movie.setId(Integer.parseInt(hash.get("id")));
		movie.setBudget(Integer.parseInt(hash.get("budget")));
		movie.setHomepagehomepage(hash.get("homepage"));
		movie.setOriginalLanguage(hash.get("original_language"));
		movie.setOriginalTitle(hash.get("original_title"));
		movie.setOverview(hash.get("overview"));
		movie.setPopularity(hash.get("popularity"));
		movie.setReleaseDate(hash.get("release_date"));
		movie.setRevenue(Long.parseLong(hash.get("revenue")));
		movie.setRuntime(hash.get("runtime"));
		movie.setStatus(hash.get("status"));
		movie.setTagline(hash.get("tagline"));
		movie.setTitle(hash.get("title"));
		movie.setVoteAverage(Float.parseFloat(hash.get("vote_average")));
		movie.setVoteCount(Long.parseLong(hash.get("vote_count")));
		
		/*parse json arays in hash using 
		 *CSV_READ.parseMovieKeyWords(json array of keyworks)
		CSV_READ.parseProdCompanies( json array of production countries)
		CSV_READ.parseProductionCountries(json array of countrines)
		CSV_READ.parseSpokenLanguages(json array of spoken languages)
		CSV_READ.parseGenres(json array of geners)
		*/
		movie.setKeywords(CSV_READ.parseMovieKeyWords(hash.get("keywords")));
		movie.setProductionCompanies(CSV_READ.parseProdCompanies(hash.get("production_companies")));
		movie.setProductionCountries(CSV_READ.parseProductionCountries(hash.get("production_countries")));
		movie.setSpokenLanguages(CSV_READ.parseSpokenLanguages(hash.get("spoken_languages")));
		movie.setGenres(CSV_READ.parseGenres(hash.get("genres")));
		return movie;//return object of movies
	}
	
	/**
	 * function will convert str to json and parse data to linklist of keywords
	 * @param str
	 * @return
	 */
	private static ArrayList<KeyWord> parseMovieKeyWords(String str) {
		try {
			str = str.replace("\"\"", "\""); //replace "" "
			if(str.charAt(0) == '\"') {
				str = str.substring(1, str.length());//take substring to remove " from start
			}
			JSONArray jsonArray = new JSONArray(str); //convert string to json array
			ArrayList<KeyWord> list = new ArrayList<KeyWord>();
			for(int i = 0; i < jsonArray.length(); i++) {
				try {
					JSONObject obj =  jsonArray.getJSONObject(i);//extract data and store it to its crossponding list
					list.add(new KeyWord(obj.getInt("id"), obj.getString("name")));
				}catch(Exception ex) {
					System.err.println(ex);
				}
			}
			return (list.size() > 0)?list: null;
		} catch(Exception ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
	
	
	/**
	 * function will convert str to json and parse data to linklist of productionCompanies
	 * @param str
	 * @return
	 */
	private static ArrayList<ProductionCompanies> parseProdCompanies(String str) {
		try {
			str = str.replace("\"\"", "\""); //replace "" "
			if(str.charAt(0) == '\"') {
				str = str.substring(1, str.length());//take substring to remove " from start
			}
			JSONArray jsonArray = new JSONArray(str); //convert string to json array
			ArrayList<ProductionCompanies> list = new ArrayList<ProductionCompanies>();
			for(int i = 0; i < jsonArray.length(); i++) {
				try {
					JSONObject obj =  jsonArray.getJSONObject(i);//extract data and store it to its crossponding list
					list.add(new ProductionCompanies(obj.getInt("id"), obj.getString("name")));
				}catch(Exception ex) {
					System.err.println(ex);
				}
			}
			return (list.size() > 0)?list: null;
		} catch(Exception ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
	
	
	/**
	 * function will convert str to json and parse data to linklist of production
	 * countries
	 * @param str
	 * @return
	 */
	private static ArrayList<ProductionCountries> parseProductionCountries(String str) {
		try {
			str = str.replace("\"\"", "\""); //replace "" "
			if(str.charAt(0) == '\"') {
				str = str.substring(1, str.length());//take substring to remove " from start
			}
			JSONArray jsonArray = new JSONArray(str); //convert string to json array
			ArrayList<ProductionCountries> list = new ArrayList<ProductionCountries>();
			for(int i = 0; i < jsonArray.length(); i++) {
				try {
					JSONObject obj =  jsonArray.getJSONObject(i);//extract data and store it to its crossponding list
					list.add(new ProductionCountries(obj.getString("iso_3166_1"), obj.getString("name")));
				}catch(Exception ex) {
					System.err.println(ex);
				}
			}
			return (list.size() > 0)?list: null;
		} catch(Exception ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
	
	/**
	 * function will convert str to json and parse data to linklist of spoken
	 * languages
	 * @param str
	 * @return
	 */
	private static ArrayList<SpokenLanguages> parseSpokenLanguages(String str) {
		try {
			str = str.replace("\"\"", "\""); //replace "" "
			if(str.charAt(0) == '\"') {
				str = str.substring(1, str.length());//take substring to remove " from start
			}
			JSONArray jsonArray = new JSONArray(str); //convert string to json array
			ArrayList<SpokenLanguages> list = new ArrayList<SpokenLanguages>();
			for(int i = 0; i < jsonArray.length(); i++) {//iterate over json array 
				try {
					JSONObject obj =  jsonArray.getJSONObject(i);//make json object of item at i
					//make spoken language element and put into list of spoken languages
					list.add(new SpokenLanguages(obj.getString("iso_639_1"), obj.getString("name")));
				}catch(Exception ex) {
					System.err.println(ex);
				}
			}
			return (list.size() > 0)?list: null;//return list if length is greater then 0
		} catch(Exception ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
	
	/**
	 * function will convert str to json and parse data to linklist of genres
	 * @param str
	 * @return
	 */
	private static ArrayList<Genres> parseGenres(String str) {
		try {
			str = str.replace("\"\"", "\"");// replace "" with "
			if(str.charAt(0) == '\"') {  //remove " at start
				str = str.substring(1, str.length());
			}
			JSONArray jsonArray = new JSONArray(str);  //convert str to json array
			ArrayList<Genres> list = new ArrayList<Genres>();  //define linklist of genres
			//iterate over json array and add them to linklist of genres
			for(int i = 0; i < jsonArray.length(); i++) {
				try {
					JSONObject obj =  jsonArray.getJSONObject(i);//extract json obejct at index i
					//parse json object and create enw generes object and add to list
					list.add(new Genres(obj.getInt("id"), obj.getString("name")));
				}catch(Exception ex) {
					System.err.println(ex);
				}
			}
			return (list.size() > 0)?list: null;// return genera list if it is not null
		} catch(Exception ex) {
			System.err.println(ex);
			System.exit(1);
			return null;
		}
	}
}
