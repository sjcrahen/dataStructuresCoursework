
/**
 * CSC 385 - Sorted Linked List
 * Shawn Crahen - scrah2
 * 3/04/2020
 */

public class SortedLinkedList<T extends Comparable<? super T>> {
  
  private int size;
  private Node<T> head;
  private Node<T> tail;
  private boolean ascending;

  public SortedLinkedList() {
    clear();
  }
  
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    ascending = true;
  }
  
  public int getSize() {
    return size;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    if (!isEmpty()) {
      Node<T> temp = head;
      for (int i = 0; i < size - 1; i++) {
        sb.append(temp.data.toString());
        sb.append(", ");
        temp = temp.next;
      }
      sb.append(temp.data.toString());
    }
    sb.append(")");
    return sb.toString();
  }
  
  public void add(T newData) {
    if (isEmpty()) {
      addToEmptyList(newData);
    } else {
      add(getNode(newData), newData);
    }
    size++;
  }
  
  public T remove(int index) {
    if (isEmpty())
      throw new EmptyCollectionException("Cannot remove from an empty collection.");
    
    validateIndex(index, 0, size - 1);
    
    Node<T> temp = getNode(index);
    if (index == 0) {
      head = head.next;
      head.previous = null;
      temp.next = null;
    } else if (index == size - 1) {
      tail = tail.previous;
      tail.next = null;
      temp.previous = null;
    } else {
      temp.previous.next = temp.next;
      temp.next.previous = temp.previous;
      temp.previous = null;
      temp.next = null;
    }
    size--;
    return temp.data;
  }
  
  public T get(int index) {
    validateIndex(index, 0, size - 1);
    Node<T> temp = getNode(index);
    return temp.data;
  }
  
  public void reverse() {
    ascending = !ascending;
    if (size > 1) {
      Node<T> tempCurrent = tail;
      Node<T> tempNext = tail;
      Node<T> tempPrevious = tail.previous;
      
      while (tempPrevious != null) {
        tempCurrent.next = tempPrevious;
        tempPrevious = tempPrevious.previous;
        tempNext = tempNext.next;
        tempNext.previous = tempCurrent;
        tempCurrent = tempCurrent.next;
      }
      
      head = tail;
      tail = tempCurrent;
      head.previous = null;
      tail.next = null;
    }
  }
  
  public boolean contains(T item) {
    Node<T> temp = head;
    for (int i = 0; i < size; i++) {
      if (temp.data.equals(item))
        return true;
      temp = temp.next;
    }
    return false;
  }
  
  private boolean isEmpty() {
    return size == 0;
  }

  private void addToEmptyList(T newData) {
    Node<T> newNode = new Node<T>(newData);
    head = newNode;
    tail = newNode;
  }
  
  private void add(Node<T> temp, T newData) {
    if (temp == head)
      prepend(newData);
    else if (temp == tail.next)
      append(newData);
    else {
      insert(temp, newData);
    }
  }

  private void prepend(T newData) {
    Node<T> newNode = new Node<T>(newData);
    newNode.next = head;
    head.previous = newNode;
    head = newNode;    
  }

  private void append(T newData) {
    Node<T> newNode = new Node<T>(newData);
    newNode.previous = tail;
    tail.next = newNode;
    tail = newNode;
  }
  
  private void insert(Node<T> temp, T newData) {
    Node<T> newNode = new Node<T>(newData);
    temp.previous.next = newNode;
    newNode.previous = temp.previous;
    temp.previous = newNode;
    newNode.next = temp;
  }
  
  private Node<T> getNode(T newData) {
    Node<T> temp = head;
    if (ascending) {
      while (temp != null && newData.compareTo(temp.data) > 0) {
        temp = temp.next;
      }
    } else {
      while (temp != null && newData.compareTo(temp.data) < 0) {
        temp = temp.next;
      }
    }
    return temp;
  }
  
  private Node<T> getNode(int index) {
    Node<T> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  private void validateIndex(int index, int lowerBound, int upperBound) {
    if (!(index >= lowerBound && index <= upperBound)) {
      throw new IndexOutOfBoundsException(String.format("Index must be between %d and %d", lowerBound, upperBound));
    }
  }
  
  private class Node<E> {
    Node<E> previous;
    E data;
    Node<E> next;
    
    private Node() {
      this(null);
    }
    
    private Node(E newData) {
      data = newData;
      previous = null;
      next = null;
    }
  }
}
