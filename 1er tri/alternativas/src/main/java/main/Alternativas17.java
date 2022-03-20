package main;

import java.util.Scanner;

public class Alternativas17 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Introduzca el numero del dado: ");
        int numeroDado=sc.nextInt();

        if (numeroDado<0 || numeroDado>6){
            System.out.println("ERROR: número incorrecto");
        }
        switch (numeroDado){
            case 1:
                System.out.println("La cara opuesta es: SEIS");
                break;
            case 2:
                System.out.println("La cara opuesta es: CINCO");
                break;
            case 3:
                System.out.println("La cara opuesta es: CUATRO");
                break;
            case 4:
                System.out.println("La cara opuesta es: TRES");
                break;
            case 5:
                System.out.println("La cara opuesta es: DOS");
                break;
            case 6:
                System.out.println("La cara opuesta es: UNO");
                break;
        }



    }
}
