// This program uses the SearchTree class to construct a binary
// search tree of strings and a binary search tree of integers
// and printing out each.
package SummerCPSC3200Assignment4;
import java.util.*;

public class SearchTreeClient {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        SearchTree<String> names = new SearchTree<String>();
        System.out.print("Name (blank to quit)? ");
        String name = console.nextLine();
        while (name.length() > 0) {
            names.add(name);
            System.out.print("Name (blank to quit)? ");
            name = console.nextLine();
        }
        System.out.println();
        System.out.println("Alphabetized list:");
        names.print();
        System.out.println();
        System.out.println("Enter Name to Remove (blank to quit): ");
        String remName = console.next();
   
        names.delete(names.getOverallRoot(names), remName);
        names.print();
        
        System.out.println("Enter Name to Remove (blank to quit): ");
        remName = console.next();
   
        names.delete(names.getOverallRoot(names), remName);
        names.print();

        System.out.println("/////  Height Checker //////");
        SearchTree<Integer> numbers = new SearchTree<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        System.out.println("The numbers BST is: ");
        numbers.print();
        System.out.println("The height of the BST is: " + numbers.height());
        
        System.out.println("/////  Number of Nodes Checker //////");
        SearchTree<Integer> numbers2 = new SearchTree<Integer>();
        numbers2.add(4);
        numbers2.add(2);
        numbers2.add(6);
        numbers2.add(1);
        numbers2.add(3);
        numbers2.add(5);
        numbers2.add(7);
        /*
         *      BST:
         *       4        (level 0) - 1 node
         *      / \
         *     2   6      (level 1) - 2 nodes  
         *    / \ / \
         *   1  3 5  7    (level 2) - 4 nodes
         */
        System.out.println("The numbers2 BST: ");
        numbers2.print();
        System.out.println("The number of nodes on level 1 is: " + numbers2.nodeCounter(numbers2.getOverallRoot(numbers2), 1));
        System.out.println("The number of nodes on level 2 is: " + numbers2.nodeCounter(numbers2.getOverallRoot(numbers2), 2));
        
        System.out.println("/////  AVL Checker //////");
        SearchTree<Integer> numbersAVLCheck = new SearchTree<Integer>();
        numbersAVLCheck.add(1);
        numbersAVLCheck.add(2);
        numbersAVLCheck.add(3);
        // Not AVL tree
        //       1
        //        \
        //         2
        //          \
        //           3
        System.out.println("The numbersAVLCheck1 BST: ");
        numbersAVLCheck.print();
        System.out.println("The BST is an AVL: " + numbersAVLCheck.IsAVL(numbersAVLCheck.getOverallRoot(numbersAVLCheck)));
        
        System.out.println("The numbersAVLCheck1 BST: ");
        numbers2.print();
        /*
         *      AVL:
         *       4        (level 0) - 1 node
         *      / \
         *     2   6      (level 1) - 2 nodes  
         *    / \ / \
         *   1  3 5  7    (level 2) - 4 nodes
         */
        System.out.println("The BST is an AVL: " + numbers2.IsAVL(numbers2.getOverallRoot(numbers2)));
        System.out.println("/////  Identical Checker //////");
        System.out.println("we are going to use the BSTs numbers and numbers2");
        System.out.println("numbers: ");
        numbers.print();
        System.out.println("nubmers2: ");
        numbers2.print();
        System.out.println(numbers.areIdentical(numbers.getOverallRoot(numbers), numbers2.getOverallRoot(numbers2))); 
        
        System.out.println("/////  Identical Checker V2 //////");
        
        SearchTree<Integer> Indentity1 = new SearchTree<Integer>();
        Indentity1.add(1);
        Indentity1.add(2);
        Indentity1.add(3);
        
        SearchTree<Integer> Indentity2 = new SearchTree<Integer>();
        Indentity2.add(1);
        Indentity2.add(2);
        Indentity2.add(3);
        
        System.out.println("we are going to use the BSTs Indentity1 and Indentity2");
        System.out.println("Indentity1: ");
        Indentity1.print();
        System.out.println("Indentity2: ");
        Indentity2.print();
        
        System.out.println(Indentity1.areIdentical(Indentity1.getOverallRoot(Indentity1), Indentity2.getOverallRoot(Indentity2)));
    }
}
