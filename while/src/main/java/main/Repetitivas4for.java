package main;

import java.util.Scanner;

public class Repetitivas4for {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("cantidad de números que va a introducir: ");
        int vecesMenosCero=0;
        int vecesMasCero=0;
        int vecesCero=0;

        for( int cantNumerosIntroducir=sc.nextInt();cantNumerosIntroducir!=0 ; cantNumerosIntroducir--){

            System.out.print("dime el número: ");
            int numeroIntroducido=sc.nextInt();

            if(numeroIntroducido>0){
                vecesMasCero++;
            }
            else if (numeroIntroducido < 0) {
                vecesMenosCero++;
            }
            else{
                vecesCero++;
            }
        }

        System.out.println("las veces que el numero ha sido MAYOR que 0: "+vecesMasCero);
        System.out.println("las veces que el numero ha sido MENOR que 0: "+vecesMenosCero);
        System.out.println("las veces que el numero ha sido IGUAL a 0: "+vecesCero);


    }
}
