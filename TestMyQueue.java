import java.util.Queue;
public class TestMyQueue {

  public static void main(String[] args) {

    Queue<String> line = new MyQueue<>();
    line.add("John");
    
    line.add("Jane");
    System.out.println(line);
    line.remove();
    
    line.add("Billy");
    System.out.println(line);
    line.remove();
    
    line.add("Cowboy");
    
    line.add("Arnold");
    
    line.add("Pam");
    System.out.println(line);
    line.remove();
    
    line.remove();
    System.out.println(line);
    
    MyQueue<String> newLine = new MyQueue<>();
    newLine.add("stuff");
    newLine.add("morestuff");
    System.out.println(newLine);

  }

}
