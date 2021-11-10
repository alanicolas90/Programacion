package debug.debug7;// Program prompts user to enter a series of integers
// separated by spaces
// Program converts them to numbers and sums them

import java.util.Scanner;

public class DebugSeven2 {
    public static void main(String[] args) {
        String str;
        int x;
        int length;
        int num;
        int lastSpace = 0;
        int sum = 0;
        String partStr;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a series of integers separated by spaces >> ");
        str = in.nextLine();
        length = str.length();
        for (x = 0; x <= length; ++x) {
            if (str.charAt(x) == ' ') {
                partStr = str.substring(x, lastSpace + 1);
                num = Integer.parseInt(partStr);
                System.out.println("                " + num);
                sum = num + sum;
                x = lastSpace;
            }
        }
        partStr = str.substring(lastSpace + 1, length);
        num = Integer.parseInt(partStr);
        System.out.println("                " + num);
        sum = num;
        System.out.println("         -------------------" +
                "\nThe sum of the integers is " + sum);
    }
}
