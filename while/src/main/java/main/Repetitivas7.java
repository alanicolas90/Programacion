package main;

import java.util.Scanner;

public class Repetitivas7 {
    public void media(Scanner sc){
        int tablaDeMultiplicar;
        System.out.print("Que tabla de multiplicar desea saber");
        int numero = sc.nextInt();

        for (tablaDeMultiplicar = 10; tablaDeMultiplicar >= 0; tablaDeMultiplicar--) {
            System.out.print(tablaDeMultiplicar + "*" + numero + "=");
            int numeroMultiplicado = numero * tablaDeMultiplicar;
            System.out.println(numeroMultiplicado);

            if (tablaDeMultiplicar == 0) {
                System.out.println("\nFIN");
            }
        }
    }
}
