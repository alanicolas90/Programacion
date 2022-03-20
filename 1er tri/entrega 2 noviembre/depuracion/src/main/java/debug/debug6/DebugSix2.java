package debug.debug6;

// DebugSix2.java
// Display every character between Unicode 65 and 122
// Start new line after 20 characters
public class DebugSix2
{
   public static void main(String[] args)
   {
      char letter;
      int a;
      final int min = 65;
      final int max = 122;
      final int stopLine1 = 85;
      final int stopLine2 = 122;
      for(a = min; a <= max; a++) {
          letter = (char) a;
          System.out.print("  " + letter);
          if ((a == stopLine1) || (a == stopLine2))
              System.out.println();
      }
      System.out.println("\nEnd of application");
    }
}
