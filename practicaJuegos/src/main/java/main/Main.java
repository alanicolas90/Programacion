package main;

import dao.DaoFilaTabla;
import ui.FilaTabla;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaoFilaTabla dao = new DaoFilaTabla();

        System.out.println("Seleccione una de la siguientes opciones:\n" +
                "1) Añadir juego.\n" +
                "2) Cambiar puntuación de un juego.\n" +
                "3) Borrar un juego.\n" +
                "4) Obterner puntuación de un juego.\n" +
                "5) Ver todos los juegos.\n");

        System.out.print("Teclee el número de la opción: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("digame el nombre del juego");
                String nombreDelJuego= sc.nextLine();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                break;
        }


        dao.add(new FilaTabla("nombre", 10));
        System.out.println(Arrays.toString(dao.imprimirTabla()));
    }
}
