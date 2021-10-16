package MAIN;

import java.util.Scanner;

public class Strings2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Ponga una frase a continuacion: ");
        String frase=sc.nextLine();

        System.out.println("Ahora pon como empezaba: ");
        String comprobacion=sc.nextLine();

        if(frase.indexOf(comprobacion,0)==0){
            System.out.println("Si comienza");
        }else{
            System.out.println("No comienza");
        }
    }
}
