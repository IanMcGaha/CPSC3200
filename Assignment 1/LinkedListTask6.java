/* LinkedListTask6.java - class to solve Question 6 on assignment 1
 * Ian McGaha
 * 07-July-25
 * 
 * Write a method clone that creates a copy of a doubly linked list.
 * 
 * THIS CODE IS GOING TO BE VERY SIMILAR TO THE CODE THAT I WROTE IN THE SPRING SEMESTER
 */
package SummerCPSC3200Assignment1McGaha;


public class LinkedListTask6 {
	// class that contains tester for solving task 6
		// Note: the clone method is used for my solutions for task 4 and 5
		public static void main(String[] args) {
			//main()
			// create int arrays for constructing linked lists
					int[] numbers1 = {10,20,30,40,50};
					
					// create DoublyLinkedList to clone two linked lists
					DoublyLinkedList<Integer> cloner = new DoublyLinkedList<Integer>();
					
					// create linked list to clone
					DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
					
					// fill out linked list with numbers from array
					for(int i=0; i<numbers1.length;i++)
				    	list1.addLast(numbers1[i]);
					
				    // print linked list to ensure it was filled correctly
				    System.out.println("<< List1: " + list1.toString());
				    
				    // clone linked list to ensure it was cloned correctly
				    // (ensure correct size is stored)
				    DoublyLinkedList<Integer> list3 = new DoublyLinkedList<Integer>();
				    list3 = cloner.clone(list1);
				    System.out.println("<< List3: " + list3.toString());
				    System.out.println("<< List3 size: " + list3.size()); // expected size of 5
				    // print original lists to ensure they are stored correctly
				    System.out.println("Printing out list1 to make sure it is still original: ");
				    System.out.println("<< List1: " + list1.toString());
		}
}
