
public class TestIntegerSet {

  public static void main(String[] args) {

    System.out.println("*********************************************************");
    System.out.println("             Testing add() and utility methods");
    System.out.println("*********************************************************");
    
    IntegerSet iSet = new IntegerSet();
    
    System.out.print("Testing isEmpty(): ");
    if (iSet.isEmpty())
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(6) to empty IntegerSet: ");
    iSet.add(6);
    if (iSet.levelOrderToString().equals("[ 6 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(4) to left child: ");
    iSet.add(4);
    if (iSet.levelOrderToString().equals("[ 6, 4 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(8) to right child: ");
    iSet.add(8);
    if (iSet.levelOrderToString().equals("[ 6, 4, 8 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(2) to left child of child: ");
    iSet.add(2);
    if (iSet.levelOrderToString().equals("[ 6, 4, 8, 2 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(5) to right child of child: ");
    iSet.add(5);
    if (iSet.levelOrderToString().equals("[ 6, 4, 8, 2, 5 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(7) to right child of child: ");
    iSet.add(7);
    if (iSet.levelOrderToString().equals("[ 6, 4, 8, 2, 5, 7 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing add(9) to right child of child: ");
    iSet.add(9);
    if (iSet.levelOrderToString().equals("[ 6, 4, 8, 2, 5, 7, 9 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet is: " + iSet.toString());
    
    System.out.print("Testing toString(): ");
    if (iSet.toString().equals("[ 2, 4, 5, 6, 7, 8, 9 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    
    System.out.print("Testing levelOrderToString(): ");
    if (iSet.levelOrderToString().equals("[ 6, 4, 8, 2, 5, 7, 9 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    System.out.println("IntegerSet in level order is: " + iSet.levelOrderToString());
    
    System.out.print("Testing magnitude(): ");
    if (iSet.magnitude() == 7)
      System.out.println("Pass");
    else
      System.out.println("Fail");
    
    System.out.println();
    System.out.println("*********************************************************");
    System.out.println("                 Testing contains()");
    System.out.println("*********************************************************");
    
    System.out.println("IntegerSet is: " + iSet.toString());
    System.out.println("Testing contains(4): " + iSet.contains(4));    
    System.out.println("Testing contains(11): " + iSet.contains(11));

    System.out.println();
    System.out.println("*********************************************************");
    System.out.println("            Testing union() and intersection()");
    System.out.println("*********************************************************");
    
    IntegerSet iSet2 = new IntegerSet();
    iSet2.add(1);
    iSet2.add(2);
    iSet2.add(3);
    iSet2.add(4);
    
    System.out.println("Testing union of: ");
    System.out.println("IntegerSet 1: " + iSet.toString());
    System.out.println("IntegerSet 2: " + iSet2.toString());
    System.out.print("Union is " + iSet.union(iSet2).toString() + ": ");
    if (iSet.union(iSet2).toString().equals("[ 1, 2, 3, 4, 5, 6, 7, 8, 9 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    
    System.out.println();
    System.out.println("Testing intersection of: ");
    System.out.println("IntegerSet 1: " + iSet.toString());
    System.out.println("IntegerSet 2: " + iSet2.toString());
    System.out.print("Intersection is " + iSet.intersection(iSet2).toString() + ": ");
    if (iSet.intersection(iSet2).toString().equals("[ 2, 4 ]"))
      System.out.println("Pass");
    else
      System.out.println("Fail");
    
  }
}
