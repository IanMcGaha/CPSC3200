// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.
package SummerCPSC3200Assignment4;
public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   
    
    public SearchTreeNode<E> getSucc(SearchTreeNode<E> cur){
    	// method to find successor node (particularly for when right child is not empty)
    	cur = cur.right;
    	while (cur != null && cur.left != null) {
    		cur = cur.left;
    	}
    	return cur;
    }
    public SearchTreeNode <E> getOverallRoot(SearchTree <E> tree){
    	return tree.overallRoot;
    }
    
    public SearchTreeNode <E> delete(SearchTreeNode <E> root, E name) {
    	// method that deletes a name if it exists from the BST
    	// can not get this method to delete an overallRoot
    	// Base Case (root is null)
    	if (root == null) {
    		return root;
    	}
    	
    	// If name we are searching for is in a subtree
    	if (root.data.compareTo(name) > 0) {
    		root.left = delete(root.left, name);
    	}
    	else if (root.data.compareTo(name) < 0) {
    		root.right = delete(root.right, name);
    	}
    	else {
    		// if root matches the provided name
    		
    		if (root.left == null) {
    			// if only right child
    			return root.right;
    		}
    		
    		if (root.right == null) {
    			// if only left child
    			return root.left;
    		}
    		// when both children
    		SearchTreeNode <E> succ = getSucc(root);
    		root.data = succ.data;
    		root.right = delete(root.right,succ.data);
    	}
    	return root;
    }
    public int height() {
        return height(overallRoot);
    }
    
    public int height (SearchTreeNode <E> node) {
    	// base case: if node is null just return -1
    	if (node == null) {
    		return -1;
    	}
    	// recursively find height of left and right subtrees
    	int left = height(node.left);
    	int right = height(node.right);
    	
    	// check to see which subtree is larger
    	if (left > right) {
    		// if left larger
    		return left + 1;
    	}
    	else {
    		// if right larger
    		return right +1;
    	}
    }
    
    public int nodeCounter(SearchTreeNode <E> root, int k) {
    	// base case if node is null
    	if (root == null || k < 0) {
    		return 0;
    	}
    	return countNodeHelp(root, 0, k);
    }
    
    private int countNodeHelp (SearchTreeNode <E> root, int currentLevel, int targetLevel) {
    	if (root == null) {
    		return 0;
    	}
    	// if we have found the target level, count!
    	if (currentLevel == targetLevel) {
    		return 1;
    	}
    	// if the current level is beyond the target we do not want to go deeper
    	if (currentLevel > targetLevel) {
    		return 0;
    	}
    	// recursively count the nodes in both the left and right subtrees
    	return countNodeHelp(root.left, currentLevel + 1, targetLevel) + countNodeHelp(root.right, currentLevel + 1, targetLevel);
    }
    public boolean IsAVL(SearchTreeNode <E> root) {
    	if (IsAVLHelp(root) > -1) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public int IsAVLHelp(SearchTreeNode <E> root) {
    	// base case: empty tree is avl 
    	if (root == null) {
    		return 0;
    	}
    	// using recursion, check the left subtree
    	int leftHeight = IsAVLHelp(root.left);
    	if (leftHeight == -1) {
    		// left subtree is not avl
    		return -1;
    	}
    	
    	// using recursion, check the right subtree
    	int rightHeight = IsAVLHelp(root.right);
    	if (rightHeight == -1) {
    		// right subtree not avl
    		return -1;
    	}
    	
    	// check if the current node satisfies avl
    	int heightDifference = Math.abs(leftHeight - rightHeight);
    	if (heightDifference > 1) {
    		// if exceeds 1, not avl
    		return -1;
    	}
    	// return height of current subtree
    	return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public boolean areIdentical(SearchTreeNode<E> first, SearchTreeNode<E> second) {
    	// base case: both nodes are just null
    	if (first == null && second == null) {
    		return true;
    	}
    	// if one is null and the other not then not the same
    	if (first == null || second == null) {
    		return false;
    	}
    	// recursively run through both left and right subtrees and check for identical
    	return (first.data == second.data) && areIdentical(first.left, second.left) && 
                areIdentical(first.right, second.right);
    }

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  //  right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
