package softwareBrauereiCodeChallenge;

import java.util.Arrays;
import java.util.ArrayList;

/* 	01 - Array Split Challenge

 * Write code in your favourite programming language which splits a array into a new multi dimensional array. 
 * Each array in the parent array has a maximum length of 3.
 * 
 * 
 * You'll have an input of a string array. This Array contains an unknown number of elements.
 * 
 */

public class CodeChallenge1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] inputData = {"elem1", "elem2", "elem3", "elem4", "elem5", "elem6", "elem7"};
		System.out.println(Arrays.deepToString(arraySplitChallenge(inputData, 3)));
		System.out.println((approach2ArraySplitChallenge(inputData, 3)));
	}	


	public static String[][] arraySplitChallenge(String[] input, int childArrayMaxLength) {


		if (input.length < childArrayMaxLength) {
			return null;
		}

		int numberOfColumns = input.length % childArrayMaxLength;


		if (numberOfColumns > 0) {
			numberOfColumns = (input.length / childArrayMaxLength) + 1;
		} else {
			numberOfColumns = input.length / childArrayMaxLength;
		}

		String[][] result = new String[numberOfColumns][childArrayMaxLength];

		// track which column of the 2D array is being used
		int columnNumber = 0;

		for (int i = 0; i < input.length; i+= childArrayMaxLength ) {

			// track which row to insert data to
			int rowNumber = 0;

			// gets the next childArrayMaxLength elements and inserts it to the result at correct place
			for (int j = i ; j < i + childArrayMaxLength && j < input.length ; j++) {
				result[columnNumber][rowNumber] = input[j];				
				rowNumber++;
			}

			columnNumber++;
		}

		return result;

	}


	public static ArrayList<ArrayList<String>> approach2ArraySplitChallenge(String[] input, int childArrayMaxLength) {


		if (input.length < childArrayMaxLength) {
			return null;
		}

		int numberOfColumns = input.length % childArrayMaxLength;


		if (numberOfColumns > 0) {
			numberOfColumns = (input.length / childArrayMaxLength) + 1;
		} else {
			numberOfColumns = input.length / childArrayMaxLength;
		}

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < input.length; i+= childArrayMaxLength ) {
			ArrayList<String> row = new ArrayList<>();
			// gets the next childArrayMaxLength elements and inserts it to the result at correct place
			for (int j = i ; j < i + childArrayMaxLength && j < input.length ; j++) {
				row.add(input[j]);		
			}
			result.add(row);

		}

		return result;
	}



}
