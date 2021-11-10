package debug.debug6;// DebugSix3.java
// Prompt user for value to start
// Value must be between 1 and 20 inclusive
// At command line, count down to blastoff
// With a brief pause between each displayed value

import javax.swing.*;

public class DebugSix3 {
    public static void main(String[] args) {
        String userNumString;
        int userNum;
        int val;
        final int min = 1;
        final int max = 20;
        userNumString = JOptionPane.showInputDialog(null,
                "Enter a number between " + min + " and " + max + " inclusive");
        userNum = Integer.parseInt(userNumString);
        while (userNum < min || userNum > max) {
            userNumString = JOptionPane.showInputDialog(null,
                    "Number out of range" +
                            "\nEnter a number between " + min + " and " + max + " inclusive");
            userNum = Integer.parseInt(userNumString);
        }
        for (val = userNum; val != 0; --val) {
            System.out.print(val + "  ");
        }
        System.out.println("Blastoff!");
    }
}






