package MAIN;

import java.util.Scanner;

public class Strings81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pon una frase con mayusculas y minusculas: ");
        String frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLowerCase(frase.charAt(i))) {
                char newLetter= (char) (frase.charAt(i)-32);
                System.out.print(newLetter);
            } else if (Character.isUpperCase(frase.charAt(i))) {
                char newLetter= (char) (frase.charAt(i)+ 32);
                System.out.print(newLetter);
            } else {
                System.out.print(" ");
            }
        }
    }
}
