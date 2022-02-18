package main;

import java.util.Random;
import java.util.Scanner;

public class Jedi {
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
            //Pedimos a cada jugador la apuesta monetaria que quiere hacer
            apuestaJugadores(cantidadJugadores, sc, dinero);

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
        Random r = getRandom();
        int number;
        for (int i = 0; i < numbers.length; i++) {
            number = r.nextInt(24) - 3;

            numbers[i] = number;
        }
        utils.barajar(numbers);
    }


    private Random getRandom() {
        return new Random();
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

    private void apuestaJugadores(int cantidadJugadores, Scanner sc, int[] dinero) {

        boolean apuestaBien = true;
        for (int i = 0; i < cantidadJugadores; i++) {
            int moneyQuiereApostar;
            do {
                System.out.println("El jugador " + (i + 1) + " cuanto dinero quieres apostar (apuesta mínima de 5)?");
                moneyQuiereApostar = sc.nextInt();
                dinero[i] += moneyQuiereApostar;
                if (moneyQuiereApostar < 5) {
                    System.out.println("La apuesta es demasiado baja por favor inténtelo de nuevo.\n");
                    dinero[i] -= moneyQuiereApostar;
                }
                //comprobamos que han apostado más o igual que el jugador anterior
                else if (i != 0) {
                    if (dinero[i] < dinero[i - 1]) {
                        System.out.println("No puedes apostar menos que el anterior, por favor inténtelo de nuevo");
                        apuestaBien = false;
                        dinero[i] -= moneyQuiereApostar;
                    }
                }
            } while (moneyQuiereApostar < 5 && apuestaBien);
        }
    }
}
