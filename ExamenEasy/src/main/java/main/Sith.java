package main;

import java.util.Random;
import java.util.Scanner;

public class Sith {
    Utilidades utils = new Utilidades();

    public void exercise1() {

        Scanner sc = new Scanner(System.in);
        int cantidadJugadores;
        int[] baraja = new int[40];
        utils.generarBaraja(baraja);
        utils.printArray(baraja);


        do {
            System.out.print("Cuantos jugadores vais a ser(mínimo 2 jugadores)? ");
            cantidadJugadores = sc.nextInt();
            if (cantidadJugadores < 2) {
                System.out.println("Valor incorrecto, prueba otra vez.\n");
            }
        } while (cantidadJugadores < 2);

        //crear un array para el dinero apostado por cada jugador
        int[] dinero = new int[cantidadJugadores];


        //tiene que haber tantas rondas como jugadores
        int rondas = cantidadJugadores;
        int[] puntosJugadoresPerdidos = new int[rondas];
        int[][] cartasJugadores = new int[rondas][cantidadJugadores];

        for (int i = 0; i < rondas; i++) {

            System.out.println("El jugador " + (i + 1) + " barajando y repartiendo las cartas a cada jugador.");
            //barajamos las cartas
            utils.barajarCeros(baraja);

            //se reparten las cartas a cada jugador y quitando las cartas ya repartidas
            for (int j = 0; j < cantidadJugadores; j++) {
                cartasJugadores[i][j] = baraja[j];
                baraja[j] = 0;
            }

            //ordenamos las cartas de tal manera que las usadas quitarlas
            utils.sort(baraja, cantidadJugadores);

            //imprimir cartas jugadores
            System.out.println("Ronda " + (i + 1));
            for (int k = 0; k < cartasJugadores.length; k++) {
                System.out.println("Jugador " + (k + 1) + ": " + cartasJugadores[i][k] + " ");
            }
            System.out.println();


            int queQuiereHacer;
            //cambiar las cartas excepto el que reparte
            for (int j = 0; j < cantidadJugadores - 1; j++) {
                do {
                    System.out.println("Turno del jugador " + ((j + i + 1) % (cantidadJugadores) + 1));
                    System.out.println("Su carta es " + cartasJugadores[i][(j + i + 1) % cantidadJugadores]);
                    System.out.println("Que quiere hacer?\n" +
                            "1) Quedarse con la carta\n" +
                            "2) Cambiar carta con el siguiente jugador");
                    queQuiereHacer = sc.nextInt();

                    if (queQuiereHacer == 1) {
                        System.out.println("Muy bien usted se queda con su carta");
                    }
                    if (queQuiereHacer == 2) {
                        //el siguiente jugador tiene un 12
                        if (cartasJugadores[i][(j + i + 1) % cantidadJugadores] == 12) {
                            System.out.println("Usted no puede cambiar cartas porque el siguiente jugador tiene un Rey, se procederá a saltarse la ronda");
                        } else {
                            //intercambio de cartas entre el siguiente jugador y el jugador
                            int aux = cartasJugadores[i][(j + i + 1) % cantidadJugadores];
                            cartasJugadores[i][(j + i + 1) % cantidadJugadores] = cartasJugadores[i][(j + i + 2) % cantidadJugadores];
                            cartasJugadores[i][(j + i + 2) % cantidadJugadores] = aux;
                            System.out.println("Ahora su carta es: " + cartasJugadores[i][(j + i + 1) % cantidadJugadores]);
                        }
                    }
                } while (queQuiereHacer > 2 || queQuiereHacer < 1);

            }

            //Ahora le toca al que baraja las cartas elegir lo que quiere hacer
            System.out.println("Turno del jugador " + (i + 1));
            System.out.println("Su carta es " + cartasJugadores[i][i]);
            System.out.println("Que quiere hacer?\n" +
                    "1) Quedarse con la carta.\n" +
                    "2) Cambiarla con la de la baraja.");
            queQuiereHacer = sc.nextInt();

            if (queQuiereHacer == 1) {
                System.out.println("Muy bien usted se queda con su carta");
            } else if (queQuiereHacer == 2) {
                cartasJugadores[i][i] = baraja[i];
                System.out.println("Ahora su cartas es: " + cartasJugadores[i][i]);

                if (cartasJugadores[i][i] == 12) {
                    System.out.println("Lo sentimos ha perdido, le cambiaremos su carta por un 0, ya que ha perdido.");
                    cartasJugadores[i][i] = 0;
                }
            }


            //imprimir cartas jugadores
            for (int j = 0; j < cartasJugadores.length; j++) {
                System.out.println("Jugador " + (j + 1) + ": " + cartasJugadores[i][j] + " ");
            }
            System.out.println();

            //ver quien ha tenido más puntos
            int morePoints = 0;
            for (int j = 0; j < cartasJugadores.length; j++) {
                if (cartasJugadores[i][j] > morePoints) {
                    morePoints = cartasJugadores[i][j];
                }
            }

            //ver quienes han perdido
            for (int j = 0; j < cartasJugadores.length; j++) {
                if (cartasJugadores[i][j] < morePoints)
                    puntosJugadoresPerdidos[j]++;
            }

            utils.printArray(puntosJugadoresPerdidos);


            //ordenamos las cartas de tal manera que las usadas quitarlas
            utils.sort(baraja, cantidadJugadores);
        }
        //ver quien es el que menos puntos tiene
        int menosPuntos = puntosJugadoresPerdidos[0];
        int ganador = 0;
        for (int i = 1; i < puntosJugadoresPerdidos.length; i++) {
            if (puntosJugadoresPerdidos[i] < menosPuntos) {
                menosPuntos = puntosJugadoresPerdidos[i];
                ganador = i;
            }
        }

        //el dinero ganado
        int dineroGanado = 0;
        for (int i = 0; i < dinero.length; i++) {
            dineroGanado += dinero[i];

        }
        System.out.println("El ganador es el jugador: " + (ganador + 1) + "\nY ha ganado: " + dineroGanado + " €");


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
        Random r = getR();
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

    private Random getR() {
        return new Random();
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
