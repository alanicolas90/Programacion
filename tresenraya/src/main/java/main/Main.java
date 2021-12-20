package main;

import dao.DaoTablero;
import modelo.ValoresCelda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValoresCelda vcX = ValoresCelda.X;
        ValoresCelda vcO = ValoresCelda.O;
        int contadorJugador = 0;
        Scanner sc = new Scanner(System.in);
        DaoTablero dao = new DaoTablero();


        System.out.println(dao.getTablero().toString());
        int seleccionX;
        int seleccionY;

        do {
            //pedir las coordenadas y en caso de estar mal que lo vuelvan a intentar
            do {
                System.out.println("Turno del jugador " + ((contadorJugador % 2) + 1));
                System.out.println("Dígame la coordenada X (0-2):");
                seleccionX = sc.nextInt();
                System.out.println("Dígame la coordenada Y (0-2):");
                seleccionY = sc.nextInt();
                if (seleccionX > 2 || seleccionX < 0 || seleccionY > 2 || seleccionY < 0) {
                    System.out.println("coordenadas invalidas, porfavor intentelo de nuevo.");
                }

            } while (seleccionX > 2 || seleccionX < 0 || seleccionY > 2 || seleccionY < 0);

            //imprimir en las celdas correspondientes
            if (contadorJugador % 2 == 0) {
                dao.getTablero().setCelda(seleccionX, seleccionY, vcX.toString());
            } else {
                dao.getTablero().setCelda(seleccionX, seleccionY, vcO.toString());
            }

            System.out.println(dao.getTablero().toString());

            contadorJugador++;
        } while (contadorJugador != 9);
    }
}

