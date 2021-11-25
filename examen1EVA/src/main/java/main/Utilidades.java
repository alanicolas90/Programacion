package main;

import java.util.Random;

public class Utilidades {
    public void numbersAleatorios(int[] numbers) {
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(101);
        }
    }

    public void generarBaraja(int[] baraja) {
        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = (i % 10) + 1;
        }
    }

    public void barajar(int[] baraja) {
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            int pos1 = r.nextInt(baraja.length - 1);
            int pos2 = r.nextInt(baraja.length - 1);

            int aux = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = aux;
        }
    }
    public void printArray(int[] numbers) {
        System.out.print("{ ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1)
                System.out.print(" ");
        }
        System.out.print(" }");
        System.out.println();
    }
}
