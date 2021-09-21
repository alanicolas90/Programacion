package main;

import java.util.Scanner;

public class Alternativas9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime el pimer numero: ");
        int numero1=sc.nextInt();

        System.out.print("Dime el segundo numero: ");
        int numero2=sc.nextInt();

        System.out.print("Dime el tercer numero: ");
        int numero3=sc.nextInt();

        if(numero1>numero2 && numero1>numero3){
            if(numero2>numero3){
                System.out.println(numero1+" "+numero2+" "+numero3);
            }
            else if(numero2<numero3){
                System.out.println(numero1+" "+numero3+" "+numero2);
            }
            else{
                System.out.println(numero1+" "+numero3+" "+numero2);
            }
        }
        else if(numero2>numero1 && numero2>numero3){
            if(numero1>numero3){
                System.out.println(numero2+" "+numero1+" "+numero3);
            }
            else if(numero1<numero3){
                System.out.println(numero2+" "+numero3+" "+numero1);
            }
            else{
                System.out.println(numero2+" "+numero3+" "+numero1);
            }
        }
        else if(numero3>numero1 && numero3>numero2){
            if (numero1>numero2){
                System.out.println(numero3+" "+numero1+" "+numero2);
            }
            else if(numero1<numero2){
                System.out.println(numero3+" "+numero2+" "+numero1);
            }
            else{
                System.out.println(numero3+" "+numero2+" "+numero1);
            }
        }

    }
}
