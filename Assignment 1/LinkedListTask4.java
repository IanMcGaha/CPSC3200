/* LinkedListTask4.java - class to solve Question 4 on assignment 1
 * Ian McGaha
 * 07-July-25
 * 
 * Write a method merge for merging two sorted doubly linked lists (list1 and list2) 
 * into a third doubly linked list list3. The result, list3, will contain all nodes 
 * of list1 and list2 but will also be sorted. You may have duplicates of the same element.
 * 
 * THIS CODE IS GOING TO BE VERY SIMILAR TO THE CODE THAT I WROTE IN THE SPRING SEMESTER
 */
package SummerCPSC3200Assignment1McGaha;

public class LinkedListTask4 {
	// LinkedListTask4 - class that contains tester for solving task 4
		public static void main(String[] args) {
			// main() 
			
			// create int arrays for constructing linked lists
			int[] numbers1 = {10,20,30,40,50};
			int[] numbers2 = {5,15,25,30,35,40,50,55};
			
			// create DoublyLinkedList to merge two linked lists
			DoublyLinkedList<Integer> merger = new DoublyLinkedList<Integer>();
			
			// create two linked lists to add
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
		    
		    // merge the two linked lists and print them out 
		    // (ensure correct size is stored)
		    DoublyLinkedList<Integer> list3 = new DoublyLinkedList<Integer>();
		    list3 = merger.merge(list1,list2);
		    System.out.println("<< List3: " + list3.toString());
		    System.out.println("<< List3 size: " + list3.size()); // expected size of 13
		    // print original lists to ensure they are stored correctly
		    System.out.println("Printing out list1 and list2 to make sure they are still original: ");
		    System.out.println("<< List1: " + list1.toString());
		    System.out.println("<< List2: " + list2.toString());
		    
		}
}
