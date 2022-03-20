package debug.debug7;

// Converts a string to lowercase, and
// displays the string's length
// as well as a count of letters
public class DebugSeven4
{
   public static void main(String[] args)
   {
      int numLetters = 0;
      String aString = "HELP!! I need to get 37 things DONE today!!";
      int stringLength = aString.length();
      System.out.println("In all lowercase, the sentence is: ");
      for(int i = 0; i < aString.length(); i++)
      {
         char ch = Character.toLowerCase(aString.charAt(i));
         System.out.print(ch);
         if(Character.isLetter(aString.charAt(i))){
            numLetters++;
         }
      }
      System.out.println();
      System.out.println
         ("The number of CHARACTERS in the string is " + numLetters);
      System.out.println("The number of LETTERS is " + stringLength);
   }
}
