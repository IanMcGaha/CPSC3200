// Searches for words in a dictionary text file
// and reports each word's position in the file.
package SummerCPSC3200Assignment3;
import java.io.*;
import java.util.*;

public class WordChallenge {
	public static int findFirstWordWithLetter(List<String> words, char letter) {
        int left = 0;
        int right = words.size() - 1;
        int result = -1; // Will store the index of first word with the letter
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String word = words.get(mid);
            
            if (word.charAt(0) == letter) {
                // Found a word with the letter, but need to find the FIRST one
                result = mid;
                right = mid - 1; // Continue searching left for earlier occurrence
            } else {
                // Compare the word with a hypothetical word starting with our letter
                String targetPrefix = String.valueOf(letter);
                if (word.compareTo(targetPrefix) < 0) {
                    // Current word comes before our target letter alphabetically
                    left = mid + 1;
                } else {
                    // Current word comes after our target letter alphabetically
                    right = mid - 1;
                }
            }
        }
        
        return result;
    }
	public static String[] newArr (List<String> words,int frequency, int index, int nextIndex) {
		int counter = 0;
		String[] allWords = new String[frequency];
		for(int i = index; i < nextIndex; i++) {
			allWords[counter] = words.get(i);
			counter++;
		}
		return allWords;
	}
    public static void main(String[] args)
            throws FileNotFoundException {
        System.out.println("Welcome to Scrabble word challenge!");

        // read a sorted dictionary file into a List
        Scanner in = new Scanner(new File("words-2.txt"));
        List<String> words = new ArrayList<String>();
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
        }

        // binary search the list for words
        Scanner console = new Scanner(System.in);
        System.out.print("Word to challenge ('0' to quit)? ");
        char target = console.next().charAt(0);
        while (target != '0') {
            int index = findFirstWordWithLetter(words, target);
            int nextIndex = 0; // index that next letter starts at
            int frequency = 0; // frequency of words that have specific letter
            System.out.println("Starting index of word with letter " + target + ": " + index);
            target++;
            nextIndex = findFirstWordWithLetter(words, target); //index that next letter starts at
            System.out.println("Starting index of word with letter " + target + ": " + nextIndex);
            frequency = nextIndex - index; // letter frequency is merely start index of target letter - start index of next letter
            target --;
            System.out.println("There are " + frequency + " words that start with " + target);
            // for whatever reason, when I print out the array of strings that contain the letter, it does not display the frequency information
//            String[] allWords = new String[frequency];
//            allWords = newArr(words,frequency,index,nextIndex);
//
//            System.out.println(Arrays.toString(allWords));
            System.out.print("Word to challenge ('0' to quit)? ");
            target = console.next().charAt(0);
        }
    }
}