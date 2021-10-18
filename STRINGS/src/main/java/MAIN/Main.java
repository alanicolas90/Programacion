package MAIN;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);
        int numeroEjercicio = 1;

        do {
            System.out.print("Dime el número del ejercicio y te lo muestra (pusla 0 para salir)(ejercicios del 1-12): ");
            numeroEjercicio = sc.nextInt();
            switch (numeroEjercicio) {
                case 1:
                    Strings1 ejercicio1=new Strings1();
                    sc.nextLine();
                    ejercicio1.media(sc);
                    break;
                case 2:
                    Strings2 ejercicio2=new Strings2();
                    sc.nextLine();
                    ejercicio2.media(sc);
                    break;
                case 3:
                    Strings3 ejercicio3=new Strings3();
                    sc.nextLine();
                    ejercicio3.media(sc);
                    break;
                case 4:
                    Strings4 ejercicio4=new Strings4();
                    sc.nextLine();
                    ejercicio4.media(sc);
                    break;
                case 5:
                    Strings5 ejercicio5=new Strings5();
                    sc.nextLine();
                    ejercicio5.media(sc);
                    break;
                case 6:
                    Strings6 ejercicio6=new Strings6();
                    sc.nextLine();
                    ejercicio6.media(sc);
                    break;
                case 7:
                    Strings7 ejercicio7=new Strings7();
                    sc.nextLine();
                    ejercicio7.media(sc);
                    break;
                case 8:
                    Strings8 ejercicio8=new Strings8();
                    sc.nextLine();
                    ejercicio8.media(sc);
                    break;
                case 9:
                    Strings9 ejercicio9=new Strings9();
                    sc.nextLine();
                    ejercicio9.media(sc);
                    break;
                case 10:
                    Strings10 ejercicio10=new Strings10();
                    sc.nextLine();
                    ejercicio10.media(sc);
                    break;
                case 11:
                    Strings11 ejercicio11=new Strings11();
                    sc.nextLine();
                    ejercicio11.media(sc);
                    break;
                case 12:
                    Strings81 ejercicio12=new Strings81();
                    sc.nextLine();
                    ejercicio12.media(sc);
                    break;
            }
        } while (numeroEjercicio != 0);

    }
}
