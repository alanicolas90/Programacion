package main;

import java.util.Scanner;

public class Repetitivas4 {
    public void media (Scanner sc, int i){
        System.out.print("Cuantos números va a introducir: ");
        int cantNumerosIntroducir=sc.nextInt();
        int vecesMenosCero=0;
        int vecesMasCero=0;
        int vecesCero=0;

        while(cantNumerosIntroducir!=0){
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
            cantNumerosIntroducir--;
        }
        if(cantNumerosIntroducir==0){
            System.out.println("las veces que el numero ha sido MAYOR que 0: "+vecesMasCero);
            System.out.println("las veces que el numero ha sido MENOR que 0: "+vecesMenosCero);
            System.out.println("las veces que el numero ha sido IGUAL a 0: "+vecesCero);
        }
    }

}
