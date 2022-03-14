package ui;

import servicios.ServicioOperaciones;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicioOperaciones so = new ServicioOperaciones();
        int option;
        int num1 = 0;
        int num2 = 0;

        do {
            System.out.println("1) Suma\n" +
                    "2) Resta\n" +
                    "3) Multiplicar\n" +
                    "4) Dividir\n\n" +
                    "0) Salir");

            System.out.println("que deseas hacer?");
            option = sc.nextInt();

            if (option > 0 && option < 5) {
                do {
                    System.out.println("Dime el primer número");
                    num1 = sc.nextInt();

                    System.out.println("Dime el segundo número");
                    num2 = sc.nextInt();
                    if (so.menorQueCero(num1) || so.menorQueCero(num2))
                        System.out.println("Los números tienen que ser mayores o iguales a 0");

                } while (so.menorQueCero(num1) || so.menorQueCero(num2));

            }


            switch (option) {
                case 1:
                    so = new ServicioOperaciones();
                    int resultado= so.suma(num1,num2);

                    if(resultado>=0)
                        System.out.println("El resultado es: " + resultado);
                    else
                        System.out.println("ERROR");

                    break;
                case 2:
                    so = new ServicioOperaciones();
                    resultado = so.resta(num1, num2);
                    if(resultado>=0)
                        System.out.println("El resultado es: " + resultado);
                    else
                        System.out.println("ERROR");

                    break;
                case 3:
                    so = new ServicioOperaciones();
                    resultado=so.multiplicar(num1, num2);
                    if(resultado>=0)
                        System.out.println("El resultado es: " + resultado);
                    else
                        System.out.println("ERROR");
                    break;
                case 4:
                    so = new ServicioOperaciones();
                    resultado = so.dividir(num1, num2);
                    System.out.println("El resultado es: " + resultado);
                    break;
                case 0:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("no hay tal opción");
                    break;
            }

        } while (option != 0);

    }
}
