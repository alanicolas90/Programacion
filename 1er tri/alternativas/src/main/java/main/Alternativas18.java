package main;

import java.util.Scanner;

public class Alternativas18 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Dime el numero de la semana: ");
        int numeroDelDia=sc.nextInt();

        if(numeroDelDia>=1 && numeroDelDia<=7) {

            switch (numeroDelDia) {
                case 1:
                    System.out.println("LUNES");
                    break;
                case 2:
                    System.out.println("MARTES");
                    break;
                case 3:
                    System.out.println("MIERCOLES");
                    break;
                case 4:
                    System.out.println("JUEVES");
                    break;
                case 5:
                    System.out.println("VIERNES");
                    break;
                case 6:
                    System.out.println("SABADO");
                    break;
                case 7:
                    System.out.println("DOMINGO");
                    break;
            }
        }
        else if(numeroDelDia<0){
            System.out.println("No existe numero de la semana negativo.");
        }
        else{
            System.out.println("Los dias de la semana van del 1 al 7 pringado");
        }



    }
}
