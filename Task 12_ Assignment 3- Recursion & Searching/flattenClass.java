// Java program to flatten a nested array into a single-level list
package SummerCPSC3200Assignment3;
import java.util.*;
public class flattenClass {
	//class that contains the method to flatten a nested array into a single-level list
	
		public static List<Object> flatten(Object[] arr){
			List<Object> result = new ArrayList<>();
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] instanceof Object[]) {
					// if element at index is an array, recursively flatten it 
					result.addAll(flatten((Object[]) arr[i]));
				}
				else {
					// if element at index is not array, just add it directly
					result.add(arr[i]);
				}
			}
			return result;
		}
public static void main(String[] args) {
	Object[] nestedInts = {1, new Object[] {2,new Object[] {3, new Object[] {4,5}}},6};
	System.out.println("Test:");
	System.out.println("Input: " + Arrays.deepToString(nestedInts));
	System.out.println("output: " + flatten(nestedInts));
	}
}

