package main;

import java.util.Locale;
import java.util.Scanner;

public class Alternativas8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime tu NOTA: ");
        int nota=sc.nextInt();

        System.out.print("Dime tu EDAD: ");
        int edad= sc.nextInt();
        sc.nextLine();

        System.out.print("Dime tu SEXO(SOLO DIME F/M): ");
        String sexo=sc.nextLine();

        if (nota>=5){
            if(edad>=18) {

                if(sexo.equalsIgnoreCase("F")){
                    System.out.println("ACEPTADA");
                }
                else if(sexo.equalsIgnoreCase("M")){
                    System.out.println("POSIBLE");
                }
                else{
                    System.out.println("NO ACEPTADA");
                }
            }
            else {
                System.out.println("NO ACEPTADA");
            }
        }
        else{
            System.out.println("NO ACEPTADA");
        }
    }
}
