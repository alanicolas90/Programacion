package main;

import java.util.Scanner;

public class Repetitivas {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int numeroEjercicio = 1;

        do {
            System.out.print("Dime el número del ejercicio y te lo muestra (pusla 0 para salir): ");
            numeroEjercicio = sc.nextInt();
            switch (numeroEjercicio) {
                case 1:
                    Repetitivas1 ejercicio1=new Repetitivas1();
                    ejercicio1.media(sc);
                    break;
                case 2:
                    Repetitivas2 ejercicio2=new Repetitivas2();
                    ejercicio2.media(sc);
                    break;
                case 3:
                    Repetitivas3 ejercicio3=new Repetitivas3();
                    ejercicio3.media(sc);
                    break;
                case 4:
                    Repetitivas4 ejercicio4=new Repetitivas4();
                    ejercicio4.media(sc);
                    break;
                case 5:
                    Repetitivas5 ejercicio5=new Repetitivas5();
                    ejercicio5.media(sc);
                    break;
                case 6:
                    Repetitivas6 ejercicio6=new Repetitivas6();
                    ejercicio6.media(sc);
                    break;
                case 7:
                    Repetitivas7 ejercicio7=new Repetitivas7();
                    ejercicio7.media(sc);
                    break;
                case 8:
                    Repetitivas8 ejercicio8=new Repetitivas8();
                    ejercicio8.media(sc);
                    break;
                case 9:
                    Repetitivas9 ejercicio9=new Repetitivas9();
                    ejercicio9.media(sc);
                    break;
                case 10:
                    Repetitivas10 ejercicio10=new Repetitivas10();
                    ejercicio10.media(sc);
                    break;
                case 11:
                    Repetitivas11 ejercicio11=new Repetitivas11();
                    ejercicio11.media(sc);
                    break;
                case 12:
                    Repetitivas12 ejercicio12=new Repetitivas12();
                    ejercicio12.media(sc);
                    break;
                case 13:
                    Repetitivas13 ejercicio13=new Repetitivas13();
                    ejercicio13.media(sc);
                    break;
                case 14:
                    Repetitivas14 ejercicio14=new Repetitivas14();
                    ejercicio14.media(sc);
                    break;
                case 15:
                    Repetitivas15 ejercicio15=new Repetitivas15();
                    ejercicio15.media(sc);
                    break;
                case 16:
                    Repetitivas16 ejercicio16=new Repetitivas16();
                    ejercicio16.media(sc);
                    break;
                case 17:
                    Repetitivas17 ejercicio17=new Repetitivas17();
                    ejercicio17.media(sc);
                    break;
                case 18:
                    Repetitivas18 ejercicio18=new Repetitivas18();
                    ejercicio18.media(sc);
                    break;
                case 19:
                    Repetitivas19 ejercicio19=new Repetitivas19();
                    ejercicio19.media(sc);
                    break;
                case 20:
                    Repetitivas20 ejercicio20=new Repetitivas20();
                    ejercicio20.media(sc);
                    break;
            }
        } while (numeroEjercicio != 0);

    }
}
