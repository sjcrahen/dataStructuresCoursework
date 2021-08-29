/**
 * CSC 385 - Extra Credit
 * Author: Shawn Crahen - scrah2
 * 4/15/2020
 */

import java.util.LinkedList;
import java.util.Queue;

public class AVLIntegerSet2 {
  
  private Node root;
  private int size;
  
  public AVLIntegerSet2() {
    clear();
  }
  
  public void clear() {
    root = null;
    size = 0;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }

  public int magnitude() {
    return size;
  }
  
  public int getHeight() {
    return getHeight(root) - 1;
  }
  
  private int getHeight(Node current) {
    if (current == null) {
      return 0;
    }
    
    return 1 + Math.max(current.leftSubtreeHeight, current.rightSubtreeHeight);
  }
  
  public boolean add(int newItem) {
    
    boolean result = true;
    
    if (isEmpty()) {
      root = new Node(newItem); // create root
      size++;
    } else {
      result = insert(root, newItem); // insert in order
      if (result) { // if insert was successful
        root = rebalance(root);
        size++;
      }
    }
    return result;
  }
      
  private boolean insert(Node current, int newItem) {
    
    if (newItem == current.data) { // item already exists
      return false;
    } else if (newItem < current.data) {
      if (current.leftChild != null) {
        Node leftChild = current.leftChild;
        insert(leftChild, newItem);
        current.leftChild = rebalance(leftChild);
      } else {
        current.leftChild = new Node(newItem);
      }
    } else {
      if (current.rightChild != null) {
        Node rightChild = current.rightChild;
        insert(rightChild, newItem);
        current.rightChild = rebalance(rightChild);
      } else {
        current.rightChild = new Node(newItem);
      }
    }

    return true;
  }
  
  private Node rebalance(Node subtree) {
    updateHeights(subtree);
    
    int balance = getBalance(subtree);
    
    if (balance > 1) { // imbalance in left subtree
      if (getBalance(subtree.leftChild) >= 0) { // imbalance in left subtree of left subtree
        subtree = rotateRight(subtree);
      } else { // imbalance in right subtree of left subtree
        subtree = rotateLeftRight(subtree);
      }
    } else if (balance < -1) { // imbalance in right subtree
      if (getBalance(subtree.rightChild) <= 0) { // imbalance in right subtree of right subtree
        subtree = rotateLeft(subtree);
      } else { // imbalance in left subtree of right subtree
        subtree = rotateRightLeft(subtree);
      }
    }

    return subtree;
  }
  
  private void updateHeights(Node current) {
    current.leftSubtreeHeight = getHeight(current.leftChild);
    current.rightSubtreeHeight = getHeight(current.rightChild);
  }
  
  private Node rotateRight(Node nodeN) {
    Node nodeC = nodeN.leftChild;
    nodeN.leftChild = nodeC.rightChild;
    nodeC.rightChild = nodeN;
    updateHeights(nodeN);
    updateHeights(nodeC);
    return nodeC;
  }
  
  private Node rotateLeft(Node nodeN) {
    Node nodeC = nodeN.rightChild;
    nodeN.rightChild = nodeC.leftChild;
    nodeC.leftChild = nodeN;
    updateHeights(nodeN);
    updateHeights(nodeC);
    return nodeC;
  }
  
  private Node rotateLeftRight(Node nodeN) {
    Node nodeC = nodeN.leftChild;
    nodeN.leftChild = rotateLeft(nodeC);
    return rotateRight(nodeN);
  }
  
  private Node rotateRightLeft(Node nodeN) {
    Node nodeC = nodeN.rightChild;
    nodeN.rightChild = rotateRight(nodeC);
    return rotateLeft(nodeN);
  }
  
  private int getBalance(Node subtree) {
    if (subtree == null) {
      return 0;
    }
    
    return subtree.leftSubtreeHeight - subtree.rightSubtreeHeight;
  }

  public boolean contains(int itemToFind) {
    if (isEmpty()) {
      throw new EmptyCollectionException("Cannot search an empty collection.");
    } else {
      Node current = root;
      while (current != null) {
        if (itemToFind < current.data) {
          current = current.leftChild;
        } else if (itemToFind > current.data) {
          current = current.rightChild;
        } else {
          return true;
        }
      }
      return false;
    }
  }

  public AVLIntegerSet2 union(AVLIntegerSet2 other) {
    AVLIntegerSet2 unionSet = new AVLIntegerSet2();
    
    Node current = root;
    Queue<Node> q = new LinkedList<>();
    q.add(current);
    
    while (!q.isEmpty()) {
      current = q.remove();
      unionSet.add(current.data);
      
      if (current.leftChild != null) {
        q.add(current.leftChild);
      }
      
      if (current.rightChild != null) {
        q.add(current.rightChild);
      }
    }

    current = other.root;
    q.add(current);
    
    while (!q.isEmpty()) {
      current = q.remove();
      unionSet.add(current.data);
      
      if (current.leftChild != null) {
        q.add(current.leftChild);
      }
      
      if (current.rightChild != null) {
        q.add(current.rightChild);
      }
    }
    
    return unionSet;
  }

  public AVLIntegerSet2 intersection(AVLIntegerSet2 other) {
    AVLIntegerSet2 intersectionSet = new AVLIntegerSet2();
    
    if (size <= other.size) {
      
      Node current = root;
      Queue<Node> q = new LinkedList<>();
      q.add(current);
      
      while (!q.isEmpty()) {
        current = q.remove();
        
        if (other.contains(current.data)) {
          intersectionSet.add(current.data);
        }
        
        if (current.leftChild != null) {
          q.add(current.leftChild);
        }
        
        if (current.rightChild != null) {
          q.add(current.rightChild);
        }
        
      }
    } else {
      
      Node current = other.root;
      Queue<Node> q = new LinkedList<>();
      q.add(current);
      
      while (!q.isEmpty()) {
        current = q.remove();
        
        if (this.contains(current.data)) {
          intersectionSet.add(current.data);
        }
        
        if (current.leftChild != null) {
          q.add(current.leftChild);
        }
        
        if (current.rightChild != null) {
          q.add(current.rightChild);
        }
        
      }
    }
    
    return intersectionSet;
  }

  public String toString() { // create inOrder String 
    StringBuffer sb = new StringBuffer();
    sb.append("[ ");
    inOrderToString(root, sb);
    sb.append(" ]");
    return sb.toString();
  }
  
  private void inOrderToString(Node current, StringBuffer sb) {
    if (current != null) {
      
      inOrderToString(current.leftChild, sb);
      
      if (current.leftChild != null) {
        sb.append(", ");
      }
      sb.append(current.data);
      
      if (current.rightChild != null) {
        sb.append(", ");
      }
      inOrderToString(current.rightChild, sb);
    }
  }
  
  public String levelOrderToString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[ ");
    
    Node current = root;
    
    Queue<Node> q = new LinkedList<>();
    q.add(current);
    
    while (!q.isEmpty()) {
      current = q.remove();
      sb.append(current.data);
      
      if (current.leftChild != null) {
        q.add(current.leftChild);
      }
      
      if (current.rightChild != null) {
        q.add(current.rightChild);
      }
      
      if(!q.isEmpty()) {
        sb.append(", ");
      }
    }
    
    sb.append(" ]");
    return sb.toString();
  }

  private class Node {
    
    private Node leftChild;
    private Node rightChild;
    private int data;
    private int leftSubtreeHeight;
    private int rightSubtreeHeight;
    
    public Node(int data) {
      this.data = data;
    }
    
  }
  
}
