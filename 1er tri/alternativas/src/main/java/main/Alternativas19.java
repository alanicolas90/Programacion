package main;

import java.util.Scanner;

public class Alternativas19 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime el mes en numeros (1-12): ");
        int numeroDelMes=sc.nextInt();

        if(numeroDelMes>=1 && numeroDelMes<=12){
            switch (numeroDelMes){
                case 1:
                    System.out.println("El mes de Enero tiene 31 dias.");
                    break;
                case 2:
                    System.out.println("El mes de Febrero tiene 28 o 29(en año bisiesto) dias.");
                    break;
                case 3:
                    System.out.println("El mes de Marzo tiene 31 dias.");
                    break;
                case 4:
                    System.out.println("El mes de Abril tiene 30 dias.");
                    break;
                case 5:
                    System.out.println("El mes de Mayo tiene 31 dias.");
                    break;
                case 6:
                    System.out.println("El mes de Junio tiene 30 dias.");
                    break;
                case 7:
                    System.out.println("El mes de Julio tiene 31 dias.");
                    break;
                case 8:
                    System.out.println("El mes de Agosto tiene 31 dias.");
                    break;
                case 9:
                    System.out.println("El mes de Septiembre tiene 30 dias.");
                    break;
                case 10:
                    System.out.println("El mes de Octubre tiene 31 dias.");
                    break;
                case 11:
                    System.out.println("El mes de Noviembre tiene 30 dias.");
                    break;
                case 12:
                    System.out.println("El mes de Diciembre tiene 31 dias.");
                    break;
            }
        }
        else{
            System.out.println("Los meses estan comprendidos entre 1 y 12");
        }
    }
}
