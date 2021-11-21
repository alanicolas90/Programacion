package main;

import java.util.Random;

public class Utilidades {
    public void numbersAleatorios(int[] numbers) {
        Random r = getRandom();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(20);
        }
    }

    public void numbersNoHigherFive(int[] timesNumbers) {
        Random r = getRandom();
        for (int i = 0; i < timesNumbers.length; i++) {
            timesNumbers[i] = r.nextInt(5);
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

    public void generarBaraja(int[] baraja) {
        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = (i % 10) + 1;
        }
    }

    public void barajar(int[] baraja) {
        Random r = getRandom();
        for (int i = 0; i < 1000000; i++) {
            int pos1 = r.nextInt(baraja.length - 1);
            int pos2 = r.nextInt(baraja.length - 1);

            int aux = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = aux;
        }
    }

    public void generateRandomOptions(int[] operations) {
        Random r = getRandom();
        for (int i = 0; i < operations.length; i++) {
            int randomNum = r.nextInt(5);
            if (randomNum == 0)
                randomNum = randomNum + 1;
            operations[i] = randomNum;
        }
    }

    public int sumaTodosNumbers(int[] numbers) {
        int sumaTodosNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumaTodosNumbers += numbers[i];
        }
        return sumaTodosNumbers;
    }

    public boolean esPrimo(int sumaPosImpares) {
        boolean primo = true;
        if (sumaPosImpares % 2 == 0)
            primo = false;
        for (int j = 3; j < sumaPosImpares && primo; j += 2) {
            if (sumaPosImpares % j == 0) {
                primo = false;
            }
        }

        return primo;
    }

    private Random getRandom() {
        return new Random();
    }
}
