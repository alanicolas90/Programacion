package main;

import java.util.Scanner;

public class Repetitivas14 {
    public void media(Scanner sc) {
        int position1 = 70;
        int position2 = 150;

        System.out.println("Sabiendo que una persona esta en el kilometro 70 y el otro en el kilometro 150.\n" +
                "Teniendo en cuenta que tienen la misma velocidad.");

        while (position1 != position2) {
            position2--;
            position1++;
        }
        System.out.println("Se encuentran en el km " + position1);
    }
}
