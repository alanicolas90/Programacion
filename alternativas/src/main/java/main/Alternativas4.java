package main;

import java.util.Scanner;

public class Alternativas4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.print("Digame su primer numero: ");
        int numero1=sc.nextInt();

        System.out.print("Digame su segundo numero: ");
        int numero2=sc.nextInt();

        int divisionEntre2Numeros=numero1%numero2;

        if(divisionEntre2Numeros==0){
            System.out.println("La division: "+numero1+"/"+numero2+ " da 0");
        }
        else{
            System.out.println("la division: "+numero1+"/"+numero2+" NO da 0");
        }

    }
}
