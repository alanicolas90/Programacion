package main;

import java.util.Scanner;

public class Alternativas15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Dime la cantidad de alumnos que van de viaje de estudios: ");
        int cantidadAlumnos=sc.nextInt();

        double pagoAutobusPorAlumno=(4000/30)*cantidadAlumnos;

        if (cantidadAlumnos>=100){
            System.out.println("A cada alumno le tiene que cobrar 65€");
            System.out.println("A la compañia le tiene que pagar"+pagoAutobusPorAlumno+"€.");
           //65 por alumno
        }
        else if(cantidadAlumnos<100 && cantidadAlumnos>=50){
            System.out.println("A cada alumno le tiene que cobrar 70€.");
            System.out.println("A la compañia le tiene que pagar"+pagoAutobusPorAlumno+"€.");
            //70 por alumno
        }
        else if(cantidadAlumnos<50 && cantidadAlumnos>=30){
            System.out.println("A cada alumno le tiene que cobrar 95€.");
            System.out.println("A la compañia le tiene que pagar"+pagoAutobusPorAlumno+"€.");
            //95 por alumno
        }
        else if(cantidadAlumnos<30  && cantidadAlumnos>=1){
            int pagoPorAlumno=4000/cantidadAlumnos;
            System.out.println("A cada alumno le tiene que cobrar"+pagoPorAlumno+"€.");
            System.out.println("A la compañia le tiene que pagar 4000€.");
            //x
        }
        else{
            System.out.println("No existen alumnos negativos pardillo.");
        }


    }
}
