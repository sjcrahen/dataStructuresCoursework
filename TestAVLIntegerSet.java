
public class TestAVLIntegerSet {

    public static void main(String[] args) {

      System.out.println("*********************************************************");
      System.out.println("             Testing add() and utility methods");
      System.out.println("*********************************************************");
      
      AVLIntegerSet iSet = new AVLIntegerSet();
      
      System.out.print("Testing isEmpty(): ");
      if (iSet.isEmpty())
        System.out.println("Pass");
      else
        System.out.println("Fail");
      System.out.println("IntegerSet is: " + iSet.toString());
      
      iSet.add(2);
      iSet.add(4);
      iSet.add(5);
      iSet.add(6);
      iSet.add(7);
      iSet.add(8);
      iSet.add(9);
      
      System.out.print("Testing toString(): ");
      if (iSet.toString().equals("[ 2, 4, 5, 6, 7, 8, 9 ]"))
        System.out.println("Pass");
      else
        System.out.println("Fail");
      System.out.println("AVLIntegerSet is: " + iSet.toString());
      
      System.out.print("Testing levelOrderToString(): ");
      if (iSet.levelOrderToString().equals("[ 6, 4, 8, 2, 5, 7, 9 ]"))
        System.out.println("Pass");
      else
        System.out.println("Fail");
      System.out.println("AVLIntegerSet in level order is: " + iSet.levelOrderToString());
      
      System.out.print("Testing magnitude(): ");
      if (iSet.magnitude() == 7)
        System.out.println("Pass");
      else
        System.out.println("Fail");
      
      System.out.println("AVLIntegerSet size is: " + iSet.magnitude());
      System.out.println("AVLIntegerSet height is: " + iSet.getHeight());
      
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
      
      AVLIntegerSet iSet2 = new AVLIntegerSet();
      iSet2.add(1);
      iSet2.add(2);
      iSet2.add(3);
      iSet2.add(4);
      
      System.out.println("Testing union of: ");
      System.out.println("IntegerSet 1: " + iSet.toString());
      System.out.println("IntegerSet 2: " + iSet2.toString());
      AVLIntegerSet unionSet = iSet.union(iSet2);
      System.out.print("Union is " + unionSet.toString() + ": ");
      if (iSet.union(iSet2).toString().equals("[ 1, 2, 3, 4, 5, 6, 7, 8, 9 ]"))
        System.out.println("Pass");
      else
        System.out.println("Fail");
      System.out.println("Union set size is: " + unionSet.magnitude());
      System.out.println("Union set height is: " + unionSet.getHeight());
      
      System.out.println();
      System.out.println("Testing intersection of: ");
      System.out.println("IntegerSet 1: " + iSet.toString());
      System.out.println("IntegerSet 2: " + iSet2.toString());
      AVLIntegerSet intersectionSet = iSet.intersection(iSet2);
      System.out.print("Intersection is " + intersectionSet.toString() + ": ");
      if (iSet.intersection(iSet2).toString().equals("[ 2, 4 ]"))
        System.out.println("Pass");
      else
        System.out.println("Fail");
      System.out.println("Intersection set size is: " + intersectionSet.magnitude());
      System.out.println("Intersection set height is: " + intersectionSet.getHeight());
      
    }

}
