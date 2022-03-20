package debug.debug5;// DebugFive3.java
// Determines whether item number on order is valid
// Over 999 invalid
// Less than 111 Invalid
// Valid and less than 500 - Automotive Department
// Valid and 500 or higher Housewares Department
import java.util.Scanner;
public class DebugFive3
{
   public static void main (String[] args)
   {
      int item;
      String output="";
      final int high = 11111;
      final int low = 999;
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter item number");
      item = input.nextInt();
      if(item <= low)
          output = "Item number too low";
      else if(item >=high)
          output = "Item number too high";

      System.out.println(output);
   }
}


