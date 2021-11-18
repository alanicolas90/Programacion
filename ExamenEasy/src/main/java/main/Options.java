package main;

public class Options {
    public void option1() {
        Utilidades utils = new Utilidades();

        int[] numbers = new int[10];
        int[] timesNumbers = new int[10];

        utils.numbersAleatorios(numbers);
        utils.numbersNoHigherFive(timesNumbers);

        utils.printArray(numbers);
        utils.printArray(timesNumbers);

        //sumamos todos los valores del segundo array para saber el tamaño del tercer array
        int sizeArraySolution = 0;
        for (int i = 0; i < timesNumbers.length; i++) {
            sizeArraySolution += timesNumbers[i];
        }
        int[] solution = new int[sizeArraySolution];
        int positionSolution = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (timesNumbers[i] != 0) {
                for (int j = timesNumbers[i]; j > 0; j--) {
                    solution[positionSolution] = numbers[i];
                    positionSolution++;
                }
            }
        }
        utils.printArray(solution);

        System.out.println("------------------------------------------------\n");

        System.out.println("Baraja guarda en un array la posición de las primeras cartas");

        int[] baraja = new int[40];
        int[] positions = new int[10];

        utils.generarBaraja(baraja);
        utils.printArray(baraja);
        utils.barajar(baraja);
        utils.printArray(baraja);

        for (int i = baraja.length - 1; i >= 0; i--) {
            positions[baraja[i] - 1] = i + 1;
        }

        utils.printArray(positions);
    }

    public void option2() {
        Utilidades utils = new Utilidades();

        int[] barajaO2 = new int[40];
        int[] positions = new int[10];

        System.out.println("Baraja guarda en un array la posición de las primeras cartas");

        utils.generarBaraja(barajaO2);
        utils.printArray(barajaO2);
        utils.barajar(barajaO2);
        utils.printArray(barajaO2);

        for (int i = 0; i < barajaO2.length; i++) {
            positions[barajaO2[i] - 1] = i + 1;
        }

        utils.printArray(positions);
        System.out.println("-----------------------------------------------------------\n");
        int[] numbers = new int[10];
        int[] operations = new int[9];

        utils.numbersAleatorios(numbers);
        utils.printArray(numbers);

        //Generar el array de operaciones
        utils.generateRandomOptions(operations);
        utils.printArray(operations);

        double solution = numbers[0];
        System.out.print(numbers[0]);
        boolean posible = true;

        for (int i = 0; i < operations.length && posible; i++) {

            switch (operations[i]) {
                case 1:
                    System.out.print(" + " + numbers[i + 1]);
                    solution = solution + numbers[i + 1];
                    break;
                case 2:
                    System.out.print(" - " + numbers[i + 1]);
                    solution = solution - numbers[i + 1];
                    break;
                case 3:
                    System.out.print(" * " + numbers[i + 1]);
                    solution = solution * numbers[i + 1];
                    break;
                case 4:
                    System.out.print(" / " + numbers[i + 1]);
                    if (numbers[i + 1] != 0)
                        solution = solution / numbers[i + 1];
                    else
                        posible= false;
                    break;
                default:
                    break;
            }
        }
        System.out.println();
        if (posible)
            System.out.println(solution);
        else
            System.out.println("Lo siento no se puede hacer la operación.");
    }
}
