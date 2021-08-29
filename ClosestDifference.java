import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClosestDifference {
    
    private static MyLinkedList list = new MyLinkedList();
    private static int listSum;
    
    public static void main(String[] args) {
                
        try {
            Scanner input = new Scanner(new File("in.txt"));
            while (input.hasNextInt()) {
                list.append(input.nextInt());
            }  
            input.close();
            listSum = getSumOfListElements(list);
            System.out.println(getDifference(list.head, 0));
        } catch (FileNotFoundException e) {
            System.out.println("File \"in.txt\" does not exist in the current directory.");
        }
    }
    
    public static int getSumOfListElements(MyLinkedList list) {
        int sum = 0;
        MyLinkedList.Node temp = list.head;
        while (temp != null) {
            sum += temp.value;
            temp = temp.next;
        }
        return sum;
    }
    
    public static int getDifference(MyLinkedList.Node thisNode, int partitionSum) {
        if (thisNode == null) {
            int difference = (listSum - partitionSum) - partitionSum;
            return difference >= 0 ? difference : -difference;
        } else {
            int diffThisNodeIncluded = getDifference(thisNode.next, partitionSum + thisNode.value);
            int diffThisNodeNotIncluded = getDifference(thisNode.next, partitionSum);
            if (diffThisNodeIncluded < diffThisNodeNotIncluded)
                return diffThisNodeIncluded;
            else
                return diffThisNodeNotIncluded;
        }
    }
    
    private static class MyLinkedList {
        
        private Node head;
        
        private MyLinkedList() {
            head = null;
        }
        
        private void append(int item) {
            Node newNode = new Node(item);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        
        private class Node {
            private Node next;
            private int value;
            
            private Node(int newValue) {
                value = newValue;
                next = null;
            }
        }
    }
}
