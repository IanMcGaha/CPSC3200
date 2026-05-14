/* ArrayTask1.java - class to solve Question 1 on assignment 1
 * Ian McGaha
 * 03-July-25
 * 
 * Write a method called removeEvenLength that 
 * takes an ArrayList of strings as a parameter and removes all of
 * the strings of even length from the list.
 * 
 * THIS CODE IS GOING TO BE VERY SIMILAR TO THE CODE THAT I WROTE IN THE SPRING SEMESTER
 */
package SummerCPSC3200Assignment1McGaha;
import java.io.*;
import java.util.*;
public class ArrayTask1 {
	// Task1 - class that contains the members and methods to remove strings of even length from list
	public static void removeEven(ArrayList<String> wordList) {
		// removeEven() - remove even strings from ArrayList 
		// Implementation - check each element of an ArrayList and if remainder when divided by 2 is 0 then remove element at index from list
		for(int i = wordList.size() - 1; i >= 0; i--) {
			if (wordList.get(i).length() % 2 == 0) {
				wordList.remove(i);
			}
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
		Scanner input =  new Scanner(new File("OddandEven.txt"));
		
		// create ArrayList
		ArrayList<String> mainList = new ArrayList<String>();
		mainList = getWords(input);
				
		System.out.println(mainList.toString());
		
		// remove strings of even length and print them out
		removeEven(mainList);
		System.out.println(mainList.toString());
		
	}

}
