package main;

import java.util.Scanner;

public class Repetitivas3 {
    public void media(Scanner sc){
        System.out.println("El ejercicio te pide que le pongas numeros y luego si pones el 0 suma todos los numeros anteriores y la media tambien.");
        int sumaNums=0;
        int cantidadNumsEscritos=0;

        int numEscrito = 1;

        do{
            System.out.print("Ponga el numero a continuación (si pones 0 se acaba): ");
            numEscrito=sc.nextInt();
            sumaNums=sumaNums+numEscrito;
            cantidadNumsEscritos++;

        }while(numEscrito!=0);

        if(numEscrito==0){
            double media=sumaNums/(cantidadNumsEscritos-1);
            System.out.println("la suma de todos lo números es: "+sumaNums);
            System.out.println("la media es: "+ media);
        }
    }
}
