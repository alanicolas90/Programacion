package main;

import java.util.Scanner;

public class Alternativas7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Digame la base de la potencia: ");
        int baseDeLaPotencia=sc.nextInt();

        System.out.print("Digame el exponente de la potencia: ");
        int exponenteDeLaPotencia=sc.nextInt();

        double resultadoPotencia=  Math.pow(baseDeLaPotencia,exponenteDeLaPotencia);

        if (exponenteDeLaPotencia>0){
            System.out.println("El resultado de "+baseDeLaPotencia+" elevado a "+ exponenteDeLaPotencia+" es: "+(int)resultadoPotencia);
        }
        else if(exponenteDeLaPotencia==0){
            System.out.println("El resultado de "+baseDeLaPotencia+" elevado a "+ exponenteDeLaPotencia+" es: 1");
        }
        else if(exponenteDeLaPotencia<0){
            System.out.println("El resultado de "+baseDeLaPotencia+" elevado a "+ exponenteDeLaPotencia+" es: "+resultadoPotencia);
        }

    }

}
