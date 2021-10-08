package main;

import java.util.Scanner;

public class Alternativas13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /*final int day=22;
        final int month=9;
        final int year=2021;*/
        boolean correcto=true;
        System.out.print("Dime el dia: ");
        int dayTyped=sc.nextInt();

        System.out.print("Dime el mes: ");
        int monthTyped=sc.nextInt();

        System.out.print("Dime el año: ");
        int yearTyped=sc.nextInt();

        if(dayTyped<=31 && dayTyped>0){
            correcto=true;
        }else{
            correcto=false;

        } if(monthTyped>0 && monthTyped<=12){
            correcto=true;
        }else{
            correcto=false;
        }if (yearTyped>2021){
            correcto=true;
        }else{
            correcto=false;
        }

        if(correcto){
            System.out.println("Todos los datos introducido estan bien.");
        }else{
            System.out.println("Has introducido mal la fecha.");
        }

        /*if(day==dayTyped){
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
        }*/
    }
}
