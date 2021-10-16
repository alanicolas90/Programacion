package MAIN;

import java.util.Scanner;

public class Strings11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe a continuacion un texto en el que quieras que se cambien las letras: ");
        String frase= sc.nextLine();

        System.out.println("La letra que quieres cambiar de la frase(cogere la primera letra escrita): ");
        char letraCambiar1 = sc.next().charAt(0);

        System.out.println("La letra que quieres cambiar de la frase: ");
        char letraCambiar2 = sc.next().charAt(0);

        for (int i = 0; i < frase.length(); i++) {
            if(frase.charAt(i)==letraCambiar1){
                System.out.print(letraCambiar2);
            }else if(frase.charAt(i)==letraCambiar2){
                System.out.print(letraCambiar1);
            }
            else{
                System.out.print(frase.charAt(i));
            }
        }


    }
}
