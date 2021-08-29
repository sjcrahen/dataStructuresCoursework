
public class TestSLL {

  public static void main(String[] args) {

    SortedLinkedList<Character> sll = new SortedLinkedList<>();
    
    System.out.println("************************************************");
    System.out.println("    Testing add functions in ascending order:   ");
    System.out.println("************************************************");
    sll.add('g');
    if (sll.toString().equals("(g)"))
      System.out.println("Add to empty list: Pass");
    else
      System.out.println("Add to empty list: Fail");
    // Test prepend
    sll.add('a');
    if (sll.toString().equals("(a, g)"))
      System.out.println("Prepend: Pass");
    else
      System.out.println("Prepend: Fail");
    // Test append
    sll.add('z');
    if (sll.toString().equals("(a, g, z)"))
      System.out.println("Append: Pass");
    else
      System.out.println("Append: Fail");
    // Test insert
    sll.add('c');
    if (sll.toString().equals("(a, c, g, z)"))
      System.out.println("Insert: Pass");
    else
      System.out.println("Insert: Fail");
    System.out.println("List is: " + sll);
    
    // Test clear
    sll.clear();
    if (sll.toString().equals("()"))
      System.out.println("Clear: Pass");
    else
      System.out.println("Clear: Fail");
    System.out.println("List is cleared: " + sll);
    
    System.out.println("************************************************");
    System.out.println("   Testing add functions in descending order:   ");
    System.out.println("************************************************");
    sll.reverse();
    sll.add('g');
    // Test prepend
    sll.add('z');
    if (sll.toString().equals("(z, g)"))
      System.out.println("Prepend: Pass");
    else
      System.out.println("Prepend: Fail");
    // Test append
    sll.add('a');
    if (sll.toString().equals("(z, g, a)"))
      System.out.println("Append: Pass");
    else
      System.out.println("Append: Fail");
    // Test insert
    sll.add('c');
    if (sll.toString().equals("(z, g, c, a)"))
      System.out.println("Insert: Pass");
    else
      System.out.println("Insert: Fail");
    System.out.println("List is: " + sll);
    
    System.out.println("************************************************");
    System.out.println("              Testing get(index):               ");
    System.out.println("************************************************");
    try {
      System.out.println(sll.get(-1));
      System.out.println("IndexOutOfBoundsException: Fail");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Exception caught: " + e.toString());
    }
    try {
      System.out.println(sll.get(sll.getSize()));
      System.out.println("IndexOutOfBoundsException: Fail");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Exception caught: " + e.toString());
    }
    try {
      System.out.println("Testing get(size - 1): " + sll.get(sll.getSize() - 1));
      System.out.println("IndexOutOfBoundException (no exception): Pass");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("IndexOutOfBoundsException: Fail");
    }
    
    System.out.println("************************************************");
    System.out.println("             Testing remove(index):             ");
    System.out.println("************************************************");
    System.out.println(sll);
    Character ch = sll.remove(1);
    if (ch == 'g' && sll.toString().equals("(z, c, a)")) {
      System.out.println("Remove from middle: Pass");
      System.out.println("Character removed: " + ch);
      System.out.println("List is: " + sll.toString());
    } else {
      System.out.println("Remove from middle: Fail");
    }
    ch = sll.remove(0);
    if (ch == 'z' && sll.toString().equals("(c, a)")) {
      System.out.println("Remove from head: Pass");
      System.out.println("Character removed: " + ch);
      System.out.println("List is: " + sll.toString());
    } else {
      System.out.println("Remove from head: Fail");
    }
    ch = sll.remove(sll.getSize() - 1);
    if (ch == 'a' && sll.toString().equals("(c)")) {
      System.out.println("Remove from tail: Pass");
      System.out.println("Character removed: " + ch);
      System.out.println("List is: " + sll.toString());
    } else {
      System.out.println("Remove from tail: Fail");
    }
    sll.clear();
    try {
      ch = sll.remove(0);
      System.out.println("EmptyCollectionException: Fail");
    } catch (EmptyCollectionException e) {
      System.out.println("Exception caught: " + e.toString());
    }
    
    System.out.println("************************************************");
    System.out.println("      Testing add functions with reverse():      ");
    System.out.println("************************************************");
    sll.add('b');
    sll.add('f');
    sll.add('d');
    if (sll.toString().equals("(b, d, f)"))
      System.out.println("Add ascending: Pass");
    else
      System.out.println("Add ascending: Fail");
    System.out.println("List is: " + sll.toString());
    sll.reverse();
    if (sll.toString().equals("(f, d, b)"))
      System.out.println("Reverse(): Pass");
    else
      System.out.println("Reverse(): Fail");
    System.out.println("List is: " + sll.toString());
    sll.add('a');
    sll.add('e');
    sll.add('c');
    if (sll.toString().equals("(f, e, d, c, b, a)"))
      System.out.println("Add descending: Pass");
    else
      System.out.println("Add descending: Fail");
    System.out.println("List is: " + sll.toString());
    sll.reverse();
    if (sll.toString().equals("(a, b, c, d, e, f)"))
      System.out.println("Reverse(): Pass");
    else
      System.out.println("Reverse(): Fail");
    System.out.println("List is: " + sll.toString());
  
    System.out.println("************************************************");
    System.out.println("               Testing contains():              ");
    System.out.println("************************************************");
    System.out.println("List is: " + sll.toString());
    if (sll.contains('a'))
      System.out.println("Contains 'a': Pass");
    else
      System.out.println("Contains 'a': Fail");
    if (sll.contains('f'))
      System.out.println("Contains 'f': Pass");
    else
      System.out.println("Contains 'f': Fail");
    if (sll.contains('z'))
      System.out.println("Contains 'z': Fail");
    else
      System.out.println("Contains 'z': Pass");
  }
}
