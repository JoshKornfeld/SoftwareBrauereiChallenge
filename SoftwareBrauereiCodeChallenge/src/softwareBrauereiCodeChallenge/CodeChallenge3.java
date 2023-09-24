package softwareBrauereiCodeChallenge;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Point;



/* 03 - Sorting Objects Challenge
 * 
 * Write code in your favourite programming language which sorts the objects of the input array by several properties. 
 * The input array contains many objects which represents an invoice number. 
 * Sort this array by customer number ascending and invoice number descending..
 * 
 * You'll have an json input of an array which contains multiple objects. 
 * These objects must be sorted by customer number ascending and invoice number descending.
 * */

/*https://code.google.com/archive/p/json-simple/downloads  JSON simple library 
 * file json-simple-1.1.1.jar 
 */

public class CodeChallenge3 {

	public static void main(String[] args) {

		String pathName = "C:\\Users\\stuff\\eclipse-workspace\\SoftwareBrauereiCodeChallenge\\src\\softwareBrauereiCodeChallenge\\c3_json_input.json";

		// rearrange data into tuple for sorting

		ArrayList<Point> input = readData(pathName);
	
		System.out.println(sortData(input));

		// sort customer number first (X), in ascending order if same,
		// then sort by invoice number (Y) in descending order

	}


	public static JSONArray sortData(ArrayList<Point> input) {
		JSONArray result = new JSONArray();


		Collections.sort(input,  new Comparator<Point>() {
			public int compare(Point p1, Point p2) {

				if (Integer.valueOf((int) p1.x).compareTo((int) p2.x) == 0) {
					return Integer.valueOf((int) p2.y).compareTo((int) p1.y);
				} else {
					return Integer.valueOf((int) p1.x).compareTo((int) p2.x);
				}


			}
		});
		
		// after sort, create resulting JSON Array
		for (int i = 0; i < input.size(); i++) {
			JSONObject customerObj = new JSONObject();
			String customerNr = input.get(i).x + "";
			customerObj.put("customer_number", customerNr);
			JSONObject invoiceObj =  new JSONObject();
			JSONObject invoiceNr = new JSONObject();
			invoiceNr.put("number",input.get(i).y );
			invoiceObj.put("invoice", invoiceNr);
			invoiceObj.putAll(customerObj);
			result.add(invoiceObj);

		}


		return result;
	}

	public static ArrayList<Point> readData(String pathName) {
		JSONParser parser = new JSONParser();


		ArrayList<Point> tuples = new ArrayList<Point>();


		// read in the file

		try {
			JSONArray input = (JSONArray) parser.parse(new FileReader(pathName));
			for (Object o : input) {

				JSONObject customer = (JSONObject) o;
				String customerNumber = (String) customer.get("customer_number");

				JSONObject invoice = (JSONObject) customer.get("invoice"); 
				String invoiceNumber =  String.valueOf(invoice.get("number"));

				Point tuple = new Point(Integer.parseInt(customerNumber), Integer.parseInt(invoiceNumber));
				tuples.add(tuple);
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
		return tuples;

	}

}
