package MAIN;

import java.util.Scanner;

public class Strings1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String texto=sc.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            char caracter=texto.charAt(i);

            System.out.println(caracter);

        }


    }
}
