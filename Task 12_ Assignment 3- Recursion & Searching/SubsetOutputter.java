// program that outputs all the subsets of a set of n elements(without repeating any subsets)
package SummerCPSC3200Assignment3;
import java.util.*;
public class SubsetOutputter {
	// class that contains the methods to output all the subsets of a set of n elements(without repeating any subsets)
	public static List<List<Integer>> generateSubsets (List<Integer> set){
		// Base case: empty set has only empty subset
        if (set.isEmpty()) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        Integer firstElement = set.get(0);
        List<Integer> remainingElements = set.subList(1,set.size());

        // Recursively get all subsets that don't contain the first element
        List<List<Integer>> subsetsWithoutFirst = generateSubsets(remainingElements);
        
        // Create subsets that do contain the first element
        List<List<Integer>> subsetsWithFirst = new ArrayList<>();
        for (List<Integer> subset : subsetsWithoutFirst) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.add(firstElement);
            newSubset.addAll(subset);
            subsetsWithFirst.add(newSubset);
        }
        
        // Combine both groups
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.addAll(subsetsWithoutFirst);
        allSubsets.addAll(subsetsWithFirst);
        
        return allSubsets;
	}
	
	public static void printSubsets(List<List<Integer>> subsets) {
		// method to be able to view all subsets 
		System.out.println("All Subsets: ");
		for (int i = 0; i < subsets.size(); i++) {
            System.out.println("  " + (i + 1) + ": " + subsets.get(i));
        }
        System.out.println();
	}
	
public static void main(String[] args) {
    List<Integer> set1 = Arrays.asList(1, 2, 3);
    System.out.println("Input set: " + set1);
    
    List<List<Integer>> subsets1 = generateSubsets(set1);
    printSubsets(subsets1);
	
    List<Integer> set2 = Arrays.asList(1, 2, 3,4,5);
    System.out.println("Input set: " + set2);
    
    List<List<Integer>> subsets2 = generateSubsets(set2);
    printSubsets(subsets2);
	}
	
}
