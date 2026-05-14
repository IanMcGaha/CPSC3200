/* LinkedListTask5.java - class to solve Question 5 on assignment 1
 * Ian McGaha
 * 07-July-25
 * 
 * Write a method intersection for intersecting two sorted doubly linked lists (list1 and list2) 
 * into a third doubly linked list list3. The result, list3, will contain all nodes 
 * of list1 and list2 that are present in both but will also be sorted.
 * 
 * THIS CODE IS GOING TO BE VERY SIMILAR TO THE CODE THAT I WROTE IN THE SPRING SEMESTER
 */
package SummerCPSC3200Assignment1McGaha;

public class LinkedListTask5 {
	// LinkedListTask4 - class that contains tester for solving task 5
			public static void main(String[] args) {
				// main() 
				
				// create int arrays for constructing linked lists
				int[] numbers1 = {15,15,30,40,50};
				int[] numbers2 = {5,15,25,30,35,40,55};
				
				// create DoublyLinkedList to intersect two linked lists
				DoublyLinkedList<Integer> intersector = new DoublyLinkedList<Integer>();
				
				// create two linked lists to intersect
				DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
				DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
				
				//fill out linked lists with numbers from arrays
				for(int i=0; i<numbers1.length;i++)
			    	list1.addLast(numbers1[i]);
				
				for(int i=0; i<numbers2.length;i++)
			    	list2.addLast(numbers2[i]);
				
			    // print both linked lists to ensure they were filled correctly
			    System.out.println("<< List1: " + list1.toString());
			    System.out.println("<< List2: " + list2.toString());
			    
			    // intersect the two linked lists and print them out 
			    // (ensure correct size is stored)
			    DoublyLinkedList<Integer> list3 = new DoublyLinkedList<Integer>();
			    list3 = intersector.intersection(list1,list2);
			    System.out.println("<< List3: " + list3.toString());
			    System.out.println("<< List3 size: " + list3.size()); // expected size of 3
			    // print original lists to ensure they are stored correctly
			    System.out.println("Printing out list1 and list2 to make sure they are still original: ");
			    System.out.println("<< List1: " + list1.toString());
			    System.out.println("<< List2: " + list2.toString());
			    
			}
}
