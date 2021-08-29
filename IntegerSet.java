/**
 * CSC 385 - Assignment 7
 * Author: Shawn Crahen - scrah2
 * 4/05/2020
 */

import java.util.LinkedList;
import java.util.Queue;

public class IntegerSet {
  
  private Node root;
  private int size;
  
  public IntegerSet() {
    clear();
  }
  
  public void clear() {
    root = null;
    size = 0;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public boolean add(int newItem) { // average case O(log n)
    if (isEmpty()) {
      root = new Node(newItem);
    } else {
      Node parent = null;
      Node current = root;
      
      while (current != null) {
        parent = current;
        
        if (newItem < current.data) {
          current = current.left;
        } else if (newItem > current.data) {
          current = current.right;
        } else {
          return false;
        }
      }
      
      if (newItem < parent.data) {
        parent.left = new Node(newItem);
      } else {
        parent.right = new Node(newItem);
      }
      
    }
    size++;
    return true;
  }

  public boolean contains(int itemToFind) { // average case O(log n)
    if (isEmpty()) {
      throw new EmptyCollectionException("Cannot search an empty collection.");
    } else {
      Node current = root;
      while (current != null) {
        if (itemToFind < current.data) {
          current = current.left;
        } else if (itemToFind > current.data) {
          current = current.right;
        } else {
          return true;
        }
      }
      return false;
    }
  }

  public IntegerSet union(IntegerSet other) { // average case O(n log n)
    IntegerSet unionSet = new IntegerSet();
    
    Node current = root;
    Queue<Node> q = new LinkedList<>();
    q.add(current);
    
    while (!q.isEmpty()) {
      current = q.remove();
      unionSet.add(current.data);
      
      if (current.left != null) {
        q.add(current.left);
      }
      
      if (current.right != null) {
        q.add(current.right);
      }
    }

    current = other.root;
    q.add(current);
    
    while (!q.isEmpty()) {
      current = q.remove();
      unionSet.add(current.data);
      
      if (current.left != null) {
        q.add(current.left);
      }
      
      if (current.right != null) {
        q.add(current.right);
      }
    }
    
    return unionSet;
  }

  public IntegerSet intersection(IntegerSet other) { // average case O(n log n)
    IntegerSet intersectionSet = new IntegerSet();
    
    if (size <= other.size) {
      
      Node current = root;
      Queue<Node> q = new LinkedList<>();
      q.add(current);
      
      while (!q.isEmpty()) {
        current = q.remove();
        
        if (other.contains(current.data)) {
          intersectionSet.add(current.data);
        }
        
        if (current.left != null) {
          q.add(current.left);
        }
        
        if (current.right != null) {
          q.add(current.right);
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
        
        if (current.left != null) {
          q.add(current.left);
        }
        
        if (current.right != null) {
          q.add(current.right);
        }
        
      }
    }
    
    return intersectionSet;
  }

  public int magnitude() {
      return size;
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[ ");
    inOrderToString(root, sb);
    sb.append(" ]");
    return sb.toString();
  }
  
  private void inOrderToString(Node current, StringBuffer sb) {
    if (current != null) {
      
      inOrderToString(current.left, sb);
      
      if (current.left != null) {
        sb.append(", ");
      }
      sb.append(current.data);
      
      if (current.right != null) {
        sb.append(", ");
      }
      inOrderToString(current.right, sb);
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
      
      if (current.left != null) {
        q.add(current.left);
      }
      
      if (current.right != null) {
        q.add(current.right);
      }
      
      if(!q.isEmpty()) {
        sb.append(", ");
      }
    }
    
    sb.append(" ]");
    return sb.toString();
  }

  private class Node {
    
    private Node left;
    private Node right;
    private int data;
    
    public Node(int data) {
      this.data = data;
    }
  }
}
