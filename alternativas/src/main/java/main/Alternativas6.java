package main;

import java.util.Scanner;

public class Alternativas6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime tu nombre: ");
        String nombre=sc.nextLine();
        char inicialNombre=nombre.charAt(0);

        if (inicialNombre>=65 && inicialNombre<=90){
            System.out.println("La primera letra es mayuscula.");
        }

        else{
            System.out.println("La primera letra es minuscula");
        }





    }
    //LEER STRING Y LEER EL PRIMERO PARA VER SI ES MAYUSCULA chartAt y buscar el codigo ascii
}
