package main;

import java.util.Scanner;

public class Repetitivas18 {
    public void media(Scanner sc) {
        int segundos;
        int minutos;
        int horas;

        for (horas = 0; horas != 24; horas++) {
            for (minutos = 0; minutos != 60; minutos++) {
                for (segundos = 0; segundos != 60; segundos++) {
                    System.out.println((horas <= 9 ? "0" : "") + horas + ":" + (minutos <= 9 ? "0" : "") + minutos + ":" + (segundos <= 9 ? "0" : "") + segundos);
                    //tambien vale ("%02d:%02d:%02d %n,horas,minutos,segundos);

                }
            }
        }
        //horas + ":" + minutos + ":" + segundos
    }

}
