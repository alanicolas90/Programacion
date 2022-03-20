package main;

import java.util.Scanner;

public class Alternativas1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime un numero (se llamara A): ");
        int numeroA=sc.nextInt();

        System.out.print("Dime otro numero (se llmara B): ");
        int numeroB=sc.nextInt();

        if (numeroA>numeroB){
            System.out.println("El numero A es mayor de numero B.");
        }
        else if (numeroA<numeroB){
            System.out.println("El numero A NO es mayor que numero B.");
        }
        else {
            System.out.println("El numero A es igual que el numero B");
        }


    }
}
