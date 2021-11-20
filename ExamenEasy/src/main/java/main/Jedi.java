package main;

import java.util.Random;

public class Jedi {
    Utilidades utils = new Utilidades();

    public void exercise1() {

    }

    public void exercise2() {

        int[] numbers = new int[10];
        boolean cumpleTodo = false;

        for (int i = 0; i < 1000000 && !cumpleTodo; i++) {
            int sumaNumbersImpares = 0;
            int cantidadPositivos = 0;
            int cantidadNegativos = 0;
            int sumaTodosNumbers = 0;

            //generamos un array entre -3 y 20
            generateRandomWithNegatives(numbers);
            utils.printArray(numbers);

            //suma de todos los números en posiciones pares y ver si es primo
            cumpleTodo = utils.esPrimo(sumaPositionPares(numbers));

            //suma de de los números impares
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] % 2 != 0) {
                    sumaNumbersImpares += numbers[j];
                }
            }
            //comprobamos si es divisible entre 3 (supongo que al dividir entre 3 el resto sea 0)
            if (sumaNumbersImpares % 3 != 0) {
                cumpleTodo = false;
            }

            //cantidad de positivos y de negativos
            for (int j = 0; j < numbers.length; j++) {
                sumaTodosNumbers += numbers[j];
                if (numbers[j] > 0) {
                    cantidadPositivos++;
                } else {
                    cantidadNegativos++;
                }
            }

            if (cantidadPositivos < cantidadNegativos) {
                cumpleTodo = false;
            }
            if (sumaTodosNumbers < 0) {
                cumpleTodo = false;
            }
        }
        if (cumpleTodo) {
            System.out.println("Felicidades lo has conseguido con el siguiente vector: ");
            utils.printArray(numbers);
        } else {
            System.out.println("Lo siento no lo has conseguido, has perdido.");
        }
    }

    private void generateRandomWithNegatives(int[] numbers) {
        Random r = new Random();
        int number;
        for (int i = 0; i < numbers.length; i++) {
            number = r.nextInt(24) - 3;

            numbers[i] = number;
        }
        utils.barajar(numbers);
    }

    private int sumaPositionPares(int[] numbers) {
        int sumaPositionPares = 0;
        for (int j = 0; j < numbers.length; j++) {
            if ((j + 1) % 2 == 0) {
                sumaPositionPares += numbers[j];
            }
        }
        return sumaPositionPares;
    }
}
