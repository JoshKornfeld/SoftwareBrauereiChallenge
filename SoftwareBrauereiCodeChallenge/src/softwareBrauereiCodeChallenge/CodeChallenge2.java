package softwareBrauereiCodeChallenge;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/* 02 - Missing Elements Challenge
 * Write code in your favourite programming language which find these elements which are not in available in every array.
 * 
 * You'll have an json input of an array which contains multiple string arrays. 
 * This Array contains an unknown number of elements.
 *
 */

/*https://code.google.com/archive/p/json-simple/downloads  JSON simple library 
 * file json-simple-1.1.1.jar 
 */

public class CodeChallenge2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pathName = "C:\\Users\\stuff\\eclipse-workspace\\SoftwareBrauereiCodeChallenge\\src\\softwareBrauereiCodeChallenge\\c2_json_input.json";
		ArrayList<ArrayList<String>> input = readData(pathName);

		System.out.println(missingElementsChallenge(input));

	}




	public static JSONArray missingElementsChallenge(ArrayList<ArrayList<String>> input){

		JSONArray result = new JSONArray();

		Set<String> commonSet = new HashSet<String>(input.get(0));

		for (int i = 1; i < input.size(); i++) {		
			commonSet.retainAll(input.get(i));
		}

		Set<String> uncommonSet = new HashSet<String>(input.get(0));

		for (int i = 1; i < input.size(); i++) {		
			uncommonSet.addAll(input.get(i));
		}

		uncommonSet.removeAll(commonSet);
		result.add(0, new ArrayList<String>(uncommonSet));
		return result;
	}

	public static ArrayList<ArrayList<String>> readData(String pathName) {
		JSONParser parser = new JSONParser();


		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();


		// read in the file

		try {

			JSONArray input = (JSONArray) parser.parse(new FileReader(pathName));
			for (Object item : input) {
				ArrayList<String> row = (ArrayList<String>) item;
				result.add(row);
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}



}
