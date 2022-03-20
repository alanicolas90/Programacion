package main;

import java.util.Scanner;

public class Alternativas12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime un año: ");
        int year=sc.nextInt();

        if (year%4==0){
            System.out.println("el año SI es bisiesto.");
        }
        else{
            System.out.println("El año NO es bisiesto.");
        }

    }
}
