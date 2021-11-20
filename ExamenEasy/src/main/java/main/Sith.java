package main;

import java.util.Random;

public class Sith {
    Utilidades utils = new Utilidades();
    public void exercise1() {

    }

    public void exercise2() {
        int[] numbers = new int[10];
        boolean cumpleTodo = false;


        for (int i = 0; i < 1000000 && !cumpleTodo; i++) {

            int cantidadPositivos = 0;
            int cantidadNegativos = 0;
            int sumaNegativos = 0;
            int maxNumNegativo = 0;
            int sumaPositivos = 0;
            double mediaNegativos = 0;


            //generar números entre 100 y -100
            generateRandomWithNegatives(numbers);
            utils.printArray(numbers);

            //Posiciones impares los hacemos valor absoluto sumamos y tiene que dar número primo
            int sumaPosImpares = sumaPos(numbers);

            //devuelve un boolean que si se cumple que la suma de los números en las posiciones impares es primo
            cumpleTodo = utils.esPrimo(sumaPosImpares);

            //sumamos todos los positivos y sacar el mayor número negativo
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] >= 0) {
                    sumaPositivos += numbers[j];
                } else if (numbers[j] < maxNumNegativo) {
                    maxNumNegativo = numbers[j];
                }
            }

            //el cuadrado del mayor número negativo
            double maxNumNegativoPow2 = Math.pow(maxNumNegativo, 2);

            if (sumaPositivos < maxNumNegativoPow2) {
                cumpleTodo = false;
            }

            //cantidad de números positivos y negativos y compararlos
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] > 0) {
                    cantidadPositivos++;
                } else {
                    sumaNegativos += numbers[j];
                    cantidadNegativos++;
                }
            }
            if (cantidadPositivos < cantidadNegativos) {
                cumpleTodo = false;
            }

            if (cantidadNegativos != 0) {
                mediaNegativos = (double) sumaNegativos / cantidadNegativos;
            }
            //compara la suma de todos los números con la media de todos los negativos
            if (utils.sumaTodosNumbers(numbers) < mediaNegativos) {
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
            if (i == 3 || i == 7 || i == 9)
                number = r.nextInt(100) * (-1);
            else
                number = r.nextInt(100);

            numbers[i] = number;
        }
        utils.barajar(numbers);
    }

    private int sumaPos(int[] numbers) {
        int suma = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((i + 1) % 2 != 0)
                suma += Math.abs(numbers[i]);
        }
        return suma;
    }
}
