package main;

import dao.Dao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Dao dao = new Dao();

        dao.generarBaraja();
        System.out.println(Arrays.toString(dao.imprimirBaraja()));
        dao.shuffle();
        System.out.println(Arrays.toString(dao.imprimirBaraja()));

        int counter = 0;
        do {
            System.out.println(dao.sacarCarta());
            System.out.println(dao.sacarCarta());
            counter++;
        } while (counter != 20);


    }
}
