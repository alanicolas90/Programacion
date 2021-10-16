package MAIN;

import java.util.Locale;
import java.util.Scanner;

public class Strings3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Ponga una frase: ");
        String frase= sc.nextLine().toLowerCase();

        System.out.println("Dime una letra para decir cuantas veces aparece (solo tomara la primera letra): ");
        char comprobacion= sc.next().toLowerCase().charAt(0);

        //String comprobacion=sc.next();

        int contador=0;

        for (int i = 0; i < frase.length(); i++) {

            if(frase.charAt(i)==comprobacion){
                contador++;
            }
        }
        System.out.println("aparece: "+contador+" veces.");

        /*int cantidadLetras = 0;
        for (int i = 0; i < linea.length(); i++) {
            i = linea.indexOf(comprobacion, i);
            if (i != -1) {
                cantidadLetras++;

            } else {
                i = linea.length();
            }
        }
        System.out.println("cantidad " + cantidadLetras);

         */
    }
}
