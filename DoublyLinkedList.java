package SummerCPSC3200Assignment1McGaha;
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//package net.datastructures;

/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DoublyLinkedList<E extends Comparable<? super E>> {

  //---------------- nested Node class ----------------
  /**
   * Node of a doubly linked list, which stores a reference to its
   * element and to both the previous and next node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;               // reference to the element stored at this node

    /** A reference to the preceding node in the list */
    private Node<E> prev;            // reference to the previous node in the list

    /** A reference to the subsequent node in the list */
    private Node<E> next;            // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param p  reference to a node that should precede the new node
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    // public accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that precedes this one (or null if no such node).
     * @return the preceding node
     */
    public Node<E> getPrev() { return prev; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Update methods
    /**
     * Sets the node's previous reference to point to Node n.
     * @param p    the node that should precede this one
     */
    public void setPrev(Node<E> p) { prev = p; }

    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the DoublyLinkedList
  /** Sentinel node at the beginning of the list */
  private Node<E> header;                    // header sentinel

  /** Sentinel node at the end of the list */
  private Node<E> trailer;                   // trailer sentinel

  /** Number of elements in the list (not including sentinels) */
  private int size = 0;                      // number of elements in the list

  /** Constructs a new empty list. */
  public DoublyLinkedList() {
    header = new Node<>(null, null, null);      // create header
    trailer = new Node<>(null, header, null);   // trailer is preceded by header
    header.setNext(trailer);                    // header is followed by trailer
  }

  // public accessor methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list.
   * @return element at the front of the list (or null if empty)
   */
  public E first() {
    if (isEmpty()) return null;
    return header.getNext().getElement();   // first element is beyond header
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {
    if (isEmpty()) return null;
    return trailer.getPrev().getElement();    // last element is before trailer
  }

  // public update methods
  /**
   * Adds an element to the front of the list.
   * @param e   the new element to add
   */
  public void addFirst(E e) {
    addBetween(e, header, header.getNext());    // place just after the header
  }

  /**
   * Adds an element to the end of the list.
   * @param e   the new element to add
   */
  public void addLast(E e) {
    addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {
    if (isEmpty()) return null;                  // nothing to remove
    return remove(header.getNext());             // first element is beyond header
  }

  /**
   * Removes and returns the last element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeLast() {
    if (isEmpty()) return null;                  // nothing to remove
    return remove(trailer.getPrev());            // last element is before trailer
  }

  // private update methods
  /**
   * Adds an element to the linked list in between the given nodes.
   * The given predecessor and successor should be neighboring each
   * other prior to the call.
   *
   * @param predecessor   node just before the location where the new element is inserted
   * @param successor     node just after the location where the new element is inserted
   */
  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    // create and link a new node
    Node<E> newest = new Node<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }

  /**
   * Removes the given node from the list and returns its element.
   * @param node    the node to be removed (must not be a sentinel)
   */
  private E remove(Node<E> node) {
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = header.getNext();
    while (walk != trailer) {
      sb.append(walk.getElement());
      walk = walk.getNext();
      if (walk != trailer)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
  
  public DoublyLinkedList<E> concatenate(DoublyLinkedList<E> list1, DoublyLinkedList<E> list2){
	  // Concatenate() - method to concatenate two DoublyLinkedLists together
	  // Implementation - Create new DoublyLinkedList (list3), set equal to list 1, point end of list3 to
	  //				  beginning of list 2, point beginning of list2 to end of list 3, change trailer
	  //				  of list3 to trailer of list2, increase size of list3 to the sum of list1 and list2
		DoublyLinkedList<E> list3 = list1.clone(list1);
		list3.trailer.prev.next = list2.header.next;
		list2.header.next.prev = list3.trailer.prev;
		list3.trailer = list2.trailer;
		list3.size = list1.size + list2.size;
		return list3;
	}
  
  public  DoublyLinkedList<E> merge(DoublyLinkedList<E> list1, DoublyLinkedList<E> list2){
	  // merge() - method to merge two list together
	  // Implementation - explained on lines below
	  // creating variables
	  DoublyLinkedList<E> list3 = new DoublyLinkedList<E>();
	  list3 = list1.clone(list1);
	  Node<E> source = list2.header.next;
	  Node<E> destination;
	  Node<E> trailerCheck = list3.header;
	  
	  while(source.next != null) { // while source has a non-null next node (nice alliteration), loop
		  destination = list3.header.next; // at loop beginning start destination at first list node
		  if (source.element.compareTo(destination.element) < 0) { // check to see if source element is less than destination element
			  while(destination.element != null && source.element.compareTo(destination.element) < 0) { // loop until appropriate sorted position is found
				  destination = destination.prev;
			  }
			  if (destination.prev != null) { // make sure destination isn't header node
			  list3.addBetween(source.element,destination.prev,destination); // add source element to list3
			  }
			  else { // if destination is the header node just addFirst()
				 list3.addFirst(source.element);
			  }
		  }
		  else if (source.element.compareTo(destination.element) >= 0) { // check to see if source element is greater than or equal to destination element
			  while(destination.element != null && source.element.compareTo(destination.element) > 0) { // loop until appropriate sorted position is found
				  destination = destination.next;
			  }
			  if (destination.next != null) { // make sure destination isn't trailer node
				  list3.addBetween(source.element,destination.prev,destination); // add source element to list3
				  }
			  else { // if destination is the trailer node just addLast()
					 list3.addLast(source.element);
				  }
		}
		  source = source.next; // increment source node to repeat loop and compare to elements already in list3
	  }
	  while(trailerCheck.next != null) { // find the trailer of the linkedlist
		  trailerCheck = trailerCheck.next;
	  }
	  list3.trailer = trailerCheck;
	  return list3;
  }
  
  public  DoublyLinkedList<E> intersection(DoublyLinkedList<E> list1, DoublyLinkedList<E> list2){
	  // intersection() - method to merge two list together without duplicates
	  // Implementation - explained on lines below
	  // creating variables
	  DoublyLinkedList<E> list3 = new DoublyLinkedList<E>();
	  list3 = list1.clone(list1);
	  Node<E> source = list3.header.next;
	  Node<E> trailerCheck = list3.header;
	  
	  while(source.next != null) { // while source has a non-null next node (nice alliteration), loop
		  if (source.next.element != null && source.element.compareTo(source.next.element) == 0) {
			  list3.remove(source);
			  source = list3.header.next;
			  continue;
		  }
		  if (list2.contains(source.element)) { // If element in list 3 (which is a copy of list 1) is in list 2 keep it
			  source = source.next;
			  continue;
		  }
		  else { // if not also in list 2 then remove the node and set the new source to the first node in list 3
			  list3.remove(source);
			  source = list3.header.next;
		  }
	  }
	  while(trailerCheck.next != null) { // find the trailer of the linkedlist
		  trailerCheck = trailerCheck.next;
	  }
	  list3.trailer = trailerCheck;
	  return list3;
  }
  
  public  DoublyLinkedList<E> union(DoublyLinkedList<E> list1, DoublyLinkedList<E> list2){
	  // union() - method to union two lists together
	  // Implementation - explained on lines below
	  // creating variables
	  DoublyLinkedList<E> list3 = new DoublyLinkedList<E>();
	  list3 = list1.clone(list1);
	  Node<E> source = list2.header.next;
	  Node<E> destination;
	  Node<E> trailerCheck = list3.header;
	  
	  while(source.next != null) { // while source has a non-null next node (nice alliteration), loop
		  destination = list3.header.next; // at loop beginning start destination at first list node
		  if (list1.contains(source.element)) { // if list1 already has element, do nothing
			  
		  }
		  else if (source.element.compareTo(destination.element) < 0) { // check to see if source element is less than destination element
			  while(destination.element != null && source.element.compareTo(destination.element) < 0) { // loop until appropriate sorted position is found
				  destination = destination.prev;
			  }
			  if (destination.prev != null) { // make sure destination isn't header node
			  list3.addBetween(source.element,destination.prev,destination); // add source element to list3
			  }
			  else { // if destination is the header node just addFirst()
				 list3.addFirst(source.element);
			  }
		  }
		  else if (source.element.compareTo(destination.element) >= 0) { // check to see if source element is greater than or equal to destination element
			  while(destination.element != null && source.element.compareTo(destination.element) > 0) { // loop until appropriate sorted position is found
				  destination = destination.next;
			  }
			  if (destination.next != null) { // make sure destination isn't trailer node
				  list3.addBetween(source.element,destination.prev,destination); // add source element to list3
				  }
			  else { // if destination is the trailer node just addLast()
					 list3.addLast(source.element);
				  }
		}
		  source = source.next; // increment source node to repeat loop and compare to elements already in list3
	  }
	  while(trailerCheck.next != null) { // find the trailer of the linkedlist
		  trailerCheck = trailerCheck.next;
	  }
	  list3.trailer = trailerCheck;
	  return list3;
  }
  public boolean contains(E element) {
	  // contains() - method to check if a list contains an element that is passed in
	  // Implementation - check all non null nodes in a list, if element within a node
	  // 				  matches the element passed in, return true
	  Node<E> cur = header.next;
	  boolean check = false;
	  while (cur.next != null) {
		  if (element.compareTo(cur.element) == 0) {
			  check = true;
			  break;
		  }
		  cur = cur.next;
	  }
	  return check;
  }
  
  public DoublyLinkedList<E> clone(DoublyLinkedList<E> list1){
	  // clone() - method to clone an existing DoublyLinkedList
	  // Implementation - create new list and addLast() all non null nodes into the new list
	  DoublyLinkedList<E> listClone = new DoublyLinkedList<E>();
	  Node<E> trailerCheck = listClone.header;
	  Node<E> cur = list1.header.next;
	  while (cur.next != null) {
		  listClone.addLast(cur.element);
		  cur = cur.next;
	  }
	  while(trailerCheck.next != null) {
		  trailerCheck = trailerCheck.next;
	  }
	  listClone.trailer = trailerCheck;
	  return listClone;
  }
  
  public static void main(String[] args) {
	    // Let's create a main with few tester calls for the methods above
	    int[] grades = {75, 87, 90, 74, 100, 66};
	    // create a new doubly linked list
	    DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
	    //add grades at the end of the list
	    for(int i=0; i<grades.length;i++)
	    	list.addLast(grades[i]);
	    //print the list's elements after adding grades at the end of the list
	    System.out.println(list.toString());
	    
	    //add grades at the head of the list
	    for(int i=0; i<grades.length;i++)
	    	list.addFirst(grades[i]);   
	    //print the list's elements after adding the grades again but at the head of the list
	    System.out.println(list.toString());
	    System.out.println(list.header.next.getElement());
	    System.out.println("The size of the list is: " +list.size);
	    System.out.println("The first element of the list is: " + list.first());
	    System.out.println("The last element of the list is: " + list.last());
	    //print the list's elements after removing the first 6 grades from the list
	    
	    for(int i=0;i<6;i++)
	    		list.removeFirst();
	    System.out.println("The current list after removing the first 6 grades: " + list.toString());
	    System.out.println("The size of the list is: " +list.size);

	    //remove the second node in the list
	    if(!list.isEmpty())
	    {
	    Node<Integer>tmp=list.header.next.next; //remember that header.next is the reference of the first element
	    list.remove(tmp); 
	    }
	    System.out.println("The list after deleting the second element: "+list.toString());
  }
  
} //----------- end of DoublyLinkedList class -----------

