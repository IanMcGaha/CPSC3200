/* ArrayTask3.java - class to solve Question 3 on assignment 1
 * Ian McGaha
 * 07-July-25
 * 
 * Write a method called removeDuplicates that takes in a sorted ArrayList and eliminates any duplicates
 * 
 * THIS CODE IS GOING TO BE VERY SIMILAR TO THE CODE THAT I WROTE IN THE SPRING SEMESTER
 */
package SummerCPSC3200Assignment1McGaha;
import java.io.*;
import java.util.*;

public class ArrayTask3 {
	// ArrayTask3 - members and methods to solve task 3
		public static ArrayList<String> getWords(Scanner input) {
			// getWords - return list with words included from text file
	        ArrayList<String> words = new ArrayList<String>();
	        while (input.hasNext()) {
	            String next = input.next().toLowerCase();
	                words.add(next);
	        }
	        return words;
	    }
		
		public static void removeDuplicates(ArrayList<String> list) {
			// removeDuplicates() - remove any duplicates found in a list of strings
			// Implementation - Since list is sorted, duplicats should be right next to eachother.
			// 					if string is same as neighbor, delete it
			for (int i = 0 ; i < list.size() -1 ; i++) {
				if (list.get(i).compareTo(list.get(i+1)) == 0) {
					list.remove(i);
					i--;
				}
			}
		}
		public static void main(String[] args) throws FileNotFoundException {
			// main()
			
					// create scanner 
					Scanner input =  new Scanner(new File("removeDuplicate.txt"));
					
					// create ArrayList
					ArrayList<String> mainList = new ArrayList<String>();
					mainList = getWords(input);
					Collections.sort(mainList);
					
					// print list
					System.out.println(mainList.toString());
					
					// remove duplicates and print list again
					removeDuplicates(mainList);
					System.out.println(mainList.toString());
					
					// Test for empty list
					ArrayList<String> empty = new ArrayList<String>();
					removeDuplicates(empty);
					System.out.println("There are no errors when running method on empty list!");
		}

}
