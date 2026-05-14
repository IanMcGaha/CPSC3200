/* ArrayTask2.java - class to solve Question 2 on assignment 1
 * Ian McGaha
 * 07-July-25
 * 
 * Write a method called doubleList that takes an ArrayList of strings and replaces every string 
 * with two of that same string
 * 
 * THIS CODE IS GOING TO BE VERY SIMILAR TO THE CODE THAT I WROTE IN THE SPRING SEMESTER
 */
package SummerCPSC3200Assignment1McGaha;

import java.io.*;
import java.util.*;

public class ArrayTask2 {
	// ArrayTask2 - class with the members and methods to solve task 2
		public static void doubleList(ArrayList<String> list) {
			// doubleList() - double the strings found in ArrayList
			// Implementation - add same element found at index then increase index by 2
			for (int i = 0 ; i < list.size() ; i += 2 ) {
				list.add(i, list.get(i));
			}
		}
		
		public static ArrayList<String> getWords(Scanner input) {
			// getWords - return list with words included from text file
	        ArrayList<String> words = new ArrayList<String>();
	        while (input.hasNext()) {
	            String next = input.next().toLowerCase();
	                words.add(next);
	        }
	        return words;
	    }
		public static void main(String[] args) throws FileNotFoundException {
			// main()
			
					// create scanner 
					Scanner input =  new Scanner(new File("doubleList.txt"));
					
					// create ArrayList
					ArrayList<String> mainList = new ArrayList<String>();
					mainList = getWords(input);
					
					// print list
					System.out.println(mainList.toString());
					
					// double the list then print the list again
					doubleList(mainList);
					System.out.println(mainList.toString());
					
		}
}
