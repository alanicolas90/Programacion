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
        int seleccion;
        int seleccionY;

        do {
            //pedir las coordenadas y en caso de estar mal que lo vuelvan a intentar
            do {
                System.out.println("Turno del jugador " + ((contadorJugador % 2) + 1));
                System.out.println("Dígame la columna deseada (0-6):");
                seleccion = sc.nextInt();

                if (seleccion > 2 || seleccion < 0) {
                    System.out.println("coordenadas invalidas, porfavor intentelo de nuevo.");
                }

            } while (seleccion > 2 || seleccion < 0);

            //imprimir en las celdas correspondientes
            if (contadorJugador % 2 == 0) {
                dao.getTablero().setCelda(seleccion, seleccionY, vcX.toString());
            } else {
                dao.getTablero().setCelda(seleccion, seleccionY, vcO.toString());
            }

            System.out.println(dao.getTablero().toString());

            contadorJugador++;
        } while (contadorJugador != 9 || !dao.tresLinea());

        if(dao.tresLinea()){
            System.out.println("Fleicidades hay ganador!!!");
        }
    }
}

