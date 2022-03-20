package debug.debug5;// DebugFive4.java
// Outputs highest of four numbers

import javax.swing.*;

public class DebugFive4 {

    public static final String ENTER_AN_INTEGER = "Enter an integer";
    public static final String HIGHEST_IS = "Highest is ";

    public static void main(String[] args) {
        int one;
        int two;
        int three;
        int four;
        String str;
        String output;

        str = JOptionPane.showInputDialog(null, ENTER_AN_INTEGER);
        one = Integer.parseInt(str);
        str = JOptionPane.showInputDialog(null, ENTER_AN_INTEGER);
        two = Integer.parseInt(str);
        str = JOptionPane.showInputDialog(null, ENTER_AN_INTEGER);
        three = Integer.parseInt(str);
        str = JOptionPane.showInputDialog(null, ENTER_AN_INTEGER);
        four = Integer.parseInt(str);
        if (one > two && one < four)
            output = HIGHEST_IS + one;
        else if (two > one || two > three && two > four)
            output = HIGHEST_IS + two;
        else if (three > one && three > four)
            output = HIGHEST_IS + three;
        else
            output = HIGHEST_IS + three;
        JOptionPane.showMessageDialog(null, output);
    }
}


