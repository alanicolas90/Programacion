package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {


            do {
                System.out.println("Select any of this options (type the number):\n" +
                        "1) Option1 exercises easy\n" +
                        "2) Option2 exercises easy\n" +
                        "3) Sith exercise 1\n" +
                        "4) Sith exercise 2\n" +
                        "5) Jedi exercise 1\n" +
                        "6) Jedi exercise 2\n\n" +
                        "0) Salir");
                option = sc.nextInt();
                if (option < 1 || option > 6)
                    System.out.println("We are sorry, the number you typed is invalid");
            } while (option < 0 || option > 6);


            Options o = new Options();
            Sith sith = new Sith();
            Jedi jedi= new Jedi();
            switch (option) {
                case 1:
                    o.option1();
                    break;
                case 2:
                    o.option2();
                    break;
                case 3:
                    sith.exercise1();
                    break;
                case 4:
                    sith.exercise2();
                    break;
                case 5:
                    jedi.exercise1();
                    break;
                case 6:
                    jedi.exercise2();
                    break;


                default:
                    System.out.println("Adiós, hasta la próxima.");
                    break;
            }

        } while (option != 0);
    }
}
