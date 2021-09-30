package main;

import java.util.Scanner;

public class Repetitivas13 {
    public void media(Scanner sc,int i) {
        int week = 6;
        int day = 1;
        int totalHoursWorked = 0;

        System.out.println("Digame lo que cobra por hora: ");
        int sueldoPorHora = sc.nextInt();

        while (week > 0) {
            System.out.println("Dime las horas trabajadas el día " + day + ": ");
            int hoursWorked = sc.nextInt();
            totalHoursWorked = totalHoursWorked + hoursWorked;
            week--;
            day++;
        }
        int sueldoTotal = sueldoPorHora * totalHoursWorked;
        System.out.println("Va a cobrar: "+sueldoTotal+"€");
    }
}
