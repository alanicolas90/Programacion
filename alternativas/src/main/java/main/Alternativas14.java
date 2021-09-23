package main;

import java.util.Scanner;

public class Alternativas14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Cuantos kilos de uva quieres vender: ");
        int kilosUva=sc.nextInt();

        sc.nextLine();

        System.out.print("Que tipo de uvas son?(A/B): ");
        String tipoUva=sc.nextLine();

        if (tipoUva.equalsIgnoreCase("A")){

            System.out.print("Que tamaño son?(1/2): ");
            int sizeUva=sc.nextInt();

            if(sizeUva==1){
                int ganancias=kilosUva*20;
                System.out.println("Vas a ganar "+ganancias+" centimos respecto al precio base.");

            }
            else if(sizeUva==2){
                int ganancias=kilosUva*30;
                System.out.println("Vas a ganar "+ganancias+" centimos respecto al precio base.");

            }
            else{
                System.out.println("SOLO HAY TAMAÑO 1 y 2.");
            }
        }
        else if(tipoUva.equalsIgnoreCase("B")){

            System.out.print("Que tamaño son?(1/2): ");
            int sizeUva=sc.nextInt();

            if(sizeUva==1){
                int ganancias=kilosUva*(30);
                System.out.println("Vas a perder "+ganancias+" centimos respecto al precio base.");
            }
            else if(sizeUva==2){
                int ganancias=kilosUva*(50);
                System.out.println("Vas a perder "+ganancias+" centimos respecto al precio base.");
            }
        }
        else{
            System.out.println("No hay un tipo asi de uvas. PONGA SOLO A o B.");
        }
    }
}
