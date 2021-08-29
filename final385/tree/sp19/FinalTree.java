package final385.tree.sp19;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FinalTree<E extends Comparable<? super E>> {

    private Node<E> root;
    private int size;

    public FinalTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E newItem) {
        if (isEmpty()) {
            root = new Node<E>(newItem);
        } else {
            Node<E> parent = null;
            Node<E> temp = root;
            int result = 0;
            while (temp != null) {
                parent = temp;
                result = newItem.compareTo(temp.data);
                if (result < 0) {
                    temp = temp.left;
                } else if (result > 0) {
                    temp = temp.right;
                } else {
                    return;
                }
            }
            if (result < 0) {
                parent.left = new Node<E>(newItem);
            } else if (result > 0) {
                parent.right = new Node<E>(newItem);
            }
        }
        size += 1;
    }

    /***** STUDENT CODE HERE *********************************************/

    public LinkedList<E> getCrown(E dataToGetCrownOf) {
        LinkedList<E> result = new LinkedList<E>();
        /*** You may add code here ******/

        if (isEmpty())
            throw new NoSuchElementException("The tree is empty");
        
        Node<E> crownNode = searchBST(dataToGetCrownOf);
        
        if (isLeaf(crownNode))
            return result;
        findLeaves(result, crownNode);
        
        /*********************************/
        return result;
    }
    
    private Node<E> searchBST(E dataToFind) {

        Node<E> current = root;
        while (current != null) {
            if (dataToFind.compareTo(current.data) < 0)
                current = current.left;
            else if (dataToFind.compareTo(current.data) > 0)
                current = current.right;
            else
                return current;
        }
        throw new NoSuchElementException("The element " + dataToFind + " is not in the tree"); // item is not in the tree
    }
    
    // recursively traverses the tree inOrder and adds leaves to list
    private void findLeaves(LinkedList<E> list, Node<E> current) {
        
        if (current != null) {
            
            findLeaves(list, current.left);
            
            if (isLeaf(current))
                list.add(current.data);
            
            findLeaves(list, current.right);
            
        }
    }
    
    private boolean isLeaf(Node<E> n) {
        return n.left == null && n.right == null;
    }

    /*******************************************************************/

    class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String test1 = "NMQGHADTSRPO";
        FinalTree<String> ft1 = new FinalTree<>();
        for (Character c : test1.toCharArray()) {
            ft1.add(c.toString());
        }

        System.out.println("N Crown: " + ft1.getCrown("N")); // Should print [D, H, O, R]
        System.out.println("R Crown: " + ft1.getCrown("R")); // Should print []

        FinalTree<Integer> ft2 = new FinalTree<>();
        Integer arr[] = new Integer[] { 500, 250, 750, 125, 375, 625, 850, 62, 187, 312, 437, 550, 650, 775, 900, 58,
                77, 343, 575, 770, 975, 93, 765, 773 };
        for (Integer i : arr) {
            ft2.add(i);
        }
        System.out.println("125 Crown: " + ft2.getCrown(125)); // Should print [58, 93, 187]
        System.out.println("750 Crown: " + ft2.getCrown(750)); // Should print [575, 650, 765, 773, 975]

        FinalTree<String> ft3 = new FinalTree<>();
        try {
            ft3.getCrown("G");
            System.out.println("You should raise an exception if the element is not found");
        } catch (NoSuchElementException e) {
            System.out.println("You raised a NoSuchElementException.");
        }
    }
}