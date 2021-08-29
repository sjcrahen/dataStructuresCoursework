
public class Test {

  public static void main(String[] args) {
    String testString = "daenead";
    
    int charIndex = 0;
    while (charIndex < testString.length() / 2) {
      System.out.println(testString.charAt(charIndex));
      charIndex++;
    }
    
    if (testString.length() % 2 != 0) charIndex++;
    
    while (charIndex < testString.length()) {
      System.out.println(testString.charAt(charIndex));
      charIndex++;
    }

  }

}
