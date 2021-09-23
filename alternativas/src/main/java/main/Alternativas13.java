package main;

import java.util.Scanner;

public class Alternativas13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final int day=22;
        final int month=9;
        final int year=2021;

        System.out.print("Dime el dia: ");
        int dayTyped=sc.nextInt();

        System.out.print("Dime el mes: ");
        int monthTyped=sc.nextInt();

        System.out.print("Dime el año: ");
        int yearTyped=sc.nextInt();

        if(day==dayTyped){
            if(month==monthTyped){
                if(year==yearTyped){
                    System.out.println("CORRECTO");
                }
                else{
                    System.out.println("INCORRECTO");
                }
            }
            else{
                System.out.println("INCORRECTO");
            }
        }
        else{
            System.out.println("INCORRECTO");
        }
    }
}
