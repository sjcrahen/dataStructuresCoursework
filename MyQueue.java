import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


public class MyQueue<E> implements Queue<E> {
  
  /*
   ********************* Attributes ***********************************************************************************
   */
  int queueSize = 0;
  Node<E> firstNode;
  Node<E> lastNode;
  
  
  /*
   ********************* Constructors *********************************************************************************
   */
  
  public MyQueue() {
    
  }
  
  private class Node<T> {
    private T data;
    private Node<T> next;
    
    private Node(T newData) {
      this.data = newData;
      this.next = null;
    }
    
    public Node<T> getNext() {
      return next;
    }
    
    public T getData() {
      return data;
    }
    
    public void setNext(Node<T> next) {
      this.next = next;
    }
    
  }

  
  
  
  /*
   ********************* Methods **************************************************************************************
   */

  @Override
  public int size() {

    return queueSize;
  }

  @Override
  public boolean isEmpty() {
    
    return size() == 0;
  }

  @Override
  public boolean contains(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean remove(Object o) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean add(E e) {
    Node<E> newNode = new Node<E>(e);
    if (isEmpty()) {
      firstNode = newNode;
      lastNode = newNode;
      queueSize++;
    }
    else {
      lastNode.setNext(newNode);
      lastNode = newNode;
      queueSize++;
    }
    return true;
  }

  @Override
  public boolean offer(E e) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public E remove() {
    if (!isEmpty()) {
      E item = firstNode.getData();
      firstNode = firstNode.getNext();
      queueSize--;
      return item;
    }
    else
      return null;
  }

  @Override
  public E poll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E element() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E peek() {

    return firstNode.getData();
  }
  
  public void enqueue(E e) {
    add(e);
  }
  
  public E dequeue() {
    return remove();
  }
  
  public void print() {
    System.out.print("[ ");
    if (!isEmpty()) {
      Node<E> currentNode = firstNode;
      for (int i = 0; i < queueSize - 1; i++) {
        System.out.print(currentNode.getData() + ", ");
        currentNode = currentNode.getNext();
      }
      System.out.print(currentNode.getData());
    }
    System.out.println(" ]");
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder("[");
    if (!isEmpty()) {
      Node<E> currentNode = firstNode;
      for (int i = 0; i < queueSize - 1; i++) {
        s.append(currentNode.getData().toString());
        s.append(", ");
        currentNode = currentNode.getNext();
      }
      s.append(currentNode.getData().toString());
    }
    s.append("]");
    return s.toString();
  }

}
