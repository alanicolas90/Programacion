package main;

import java.util.Scanner;

public class Alternativas11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime la longitud del lado A: ");
        int ladoA=sc.nextInt();

        System.out.print("Dime la longitud del lado B: ");
        int ladoB=sc.nextInt();

        System.out.print("Dime la longitud del lado C: ");
        int ladoC=sc.nextInt();

        if(ladoA==ladoB && ladoA==ladoC){
            System.out.println("El triangulo es equilatero.");
        }
        else if(ladoA==ladoB || ladoA==ladoC ||ladoB==ladoC){
            System.out.println("El triangulo es isosceles.");
        }

        else if(ladoA>ladoB && ladoA>ladoC){

            int hipotenusa=ladoA;
            double catetosTriangulo=Math.sqrt(Math.pow(ladoB,2)+Math.pow(ladoC,2));

            if (hipotenusa==catetosTriangulo){
                System.out.println("Es triangulo rectángulo.");
            }
            else{
                System.out.println("Es un triangulo escaleno.");
            }


        }
        else if(ladoB>ladoA && ladoB>ladoC){

            int hipotenusa=ladoB;
            double catetosTriangulo=Math.sqrt(Math.pow(ladoA,2)+Math.pow(ladoC,2));

            if (hipotenusa==catetosTriangulo){
                System.out.println("Es triangulo rectángulo.");
            }
            else{
                System.out.println("Es un triangulo escaleno.");
            }

        }
        else if(ladoC>ladoA && ladoC>ladoB){

            int hipotenusa=ladoC;
            double catetosTriangulo=Math.sqrt(Math.pow(ladoB,2)+Math.pow(ladoA,2));

            if (hipotenusa==catetosTriangulo){
                System.out.println("Es triangulo rectángulo.");
            }
            else{
                System.out.println("Es un triangulo escaleno.");
            }

        }


    }
}
