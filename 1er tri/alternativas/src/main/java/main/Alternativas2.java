package main;

import java.util.Scanner;

public class Alternativas2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Digame un numero: ");
        int number=sc.nextInt();

        if (number<0){
            System.out.println("El numero es negativo.");
        }
        else if (number>0){
            System.out.println("El numero es positivo.");
        }
        else{
            System.out.println("El numero es 0.");
        }
    }
}
