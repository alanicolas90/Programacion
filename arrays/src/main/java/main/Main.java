package main;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroEjercicio;

        do {
            System.out.print("Dime el número del ejercicio y te lo muestra (pulsa 0 para salir)(ejercicios del 1-12): ");
            numeroEjercicio = sc.nextInt();
            sc.nextLine();

            switch (numeroEjercicio) {
                case 1:
                    Arrays1 ejercicio1=new Arrays1();
                    ejercicio1.media();
                    break;
                case 2:
                    Arrays2 ejercicio2=new Arrays2();
                    ejercicio2.media();
                    break;
                case 3:
                    Arrays3 ejercicio3=new Arrays3();
                    ejercicio3.media();
                    break;
                case 4:
                    Arrays4 ejercicio4=new Arrays4();
                    ejercicio4.media();
                    break;
                case 5:
                    Arrays5 ejercicio5=new Arrays5();
                    ejercicio5.media();
                    break;
                case 6:
                    Arrays6 ejercicio6=new Arrays6();
                    ejercicio6.media();
                    break;
                case 7:
                    Arrays7 ejercicio7=new Arrays7();
                    ejercicio7.media();
                    break;
                case 8:
                    Arrays8 ejercicio8=new Arrays8();
                    ejercicio8.media();
                    break;
                case 9:
                    Arrays9 ejercicio9=new Arrays9();
                    ejercicio9.media();
                    break;
                case 10:
                    Arrays10 ejercicio10=new Arrays10();
                    ejercicio10.media(sc);
                    break;
                case 11:
                    Arrays11 ejercicio11=new Arrays11();
                    ejercicio11.media(sc);
                    break;
                case 12:
                    Arrays12 ejercicio12=new Arrays12();
                    ejercicio12.media(sc);
                    break;
                case 13:
                    Arrays13 ejercicio13=new Arrays13();
                    ejercicio13.media(sc);
                    break;
                case 14:
                    Arrays14 ejercicio14=new Arrays14();
                    ejercicio14.media(sc);
                    break;
                case 15:
                    Arrays15 ejercicio15=new Arrays15();
                    ejercicio15.media(sc);
                    break;
                case 16:
                    Arrays16 ejercicio16=new Arrays16();
                    ejercicio16.media(sc);
                    break;
                default:
                    System.out.println("There are only 16 exercises please type a number between 1-16.");
                    break;

            }
        } while (numeroEjercicio != 0);

    }


}
