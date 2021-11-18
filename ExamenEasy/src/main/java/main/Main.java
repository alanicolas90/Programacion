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
                        "2) Option2 exercises easy");
                option = sc.nextInt();
                if (option < 1 || option > 2)
                    System.out.println("We are sorry, the number you typed is invalid");
            } while (option < 0 || option > 2);

            Options o = new Options();
            switch (option) {
                case 1:
                    o.option1();
                    break;
                case 2:
                    o.option2();
                    break;

                default:
                    System.out.println("Adiós, hasta la próxima.");
                    break;
            }

        } while (option != 0);
    }
}
