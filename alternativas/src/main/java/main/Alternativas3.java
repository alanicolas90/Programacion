package main;

import java.util.Scanner;

public class Alternativas3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Digame un numero: ");
        int number=sc.nextInt();

        if (number%2==0){
            System.out.println("El numero es par.");
        }
        else{
            System.out.println("El numero es impar.");
        }

    }
}
