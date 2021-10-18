package Main;

import java.util.Scanner;

public class Cesar_codificar {

    public void media(Scanner sc){
        System.out.println("Pongame a continuacion la frase que desea cifrar con Cesar:");
        String fraseCodificar=sc.nextLine();

        for (int i = 0; i < fraseCodificar.length(); i++) {
            if(Character.isUpperCase(fraseCodificar.charAt(i)){
                System.out.println(fraseCodificar.charAt(i)+3);
            }


        }







    }
}
