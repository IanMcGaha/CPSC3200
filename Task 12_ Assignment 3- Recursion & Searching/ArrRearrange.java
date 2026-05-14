// program that rearranges the int values in an array so that even number appear before all the odd values
package SummerCPSC3200Assignment3;

import java.util.Arrays;

public class ArrRearrange {
	// class that contains the methods to rearrange int values in an array so that even number come before odd numbers 
	public static void arrRearranger(int[] arr, int left, int right) {
		if (left >= right) {
			// base case: if left is greater than or equal to right, done with this iteration
			return;
		}
		while (left < right && (arr[left] % 2) == 0) {
			// find the first odd number from left
			left++;
		}
		while (left < right && arr[right] % 2 == 1) {
			// find the first even number from the right 
			right--;
		}
		if (left < right) {
			// if an odd is found on the left and even or right, swap them
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			arrRearranger(arr, left + 1, right - 1);
		}
	}
public static void main(String[] args) {
	
	int[] test = {1,2,3,4,5,2};
	System.out.println("Test:");
	System.out.println("input: " + Arrays.toString(test));
	arrRearranger(test, 0, test.length - 1);
	System.out.println("output: " + Arrays.toString(test));
	}
}
