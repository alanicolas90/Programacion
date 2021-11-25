package main;


public class MainEj2 {

    public static void main(String[] args) {
        Utilidades utils = new Utilidades();
        boolean cumple = false;

        //generamos un array de 20 números
        int[] numbers = new int[20];

        for (int i = 0; i < 1000 && !cumple; i++) {
            //generamos números entre 0 y 100
            utils.numbersAleatorios(numbers);

            //buscar números divisibles entre 3 y sumar la posición, también números menores que 10 y sumarlos
            int sumaPositionsNumbersDivisibles3 = 0;
            int sumaNumbersMenoresQue10 = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] % 3 == 0) {
                    sumaPositionsNumbersDivisibles3 += j;
                }
                if (numbers[j] < 10) {
                    sumaNumbersMenoresQue10 += numbers[j];
                }
            }

            //buscamos primos
            int cantidadPrimos = 0;

            for (int j = 0; j < numbers.length; j++) {
                boolean primo = true;
                if (numbers[j] % 2 == 0 && numbers[j] > 2) {
                    primo = false;
                }
                for (int k = 3; k < numbers[j] && primo; k++) {
                    if (numbers[j] % k == 0) {
                        primo = false;
                    }
                }
                if (primo) {
                    cantidadPrimos++;
                }
            }
            int sumaTodosValores = 0;
            //la media
            for (int j = 0; j < numbers.length; j++) {
                sumaTodosValores += numbers[j];
            }
            double media = (double) sumaTodosValores / numbers.length;

            //cantidad de valores mayores a la media
            int cantidadMayoresMedia = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] > media) {
                    cantidadMayoresMedia++;
                }
            }

            if (sumaPositionsNumbersDivisibles3 < sumaNumbersMenoresQue10 && cantidadPrimos >= 5 && cantidadMayoresMedia >= 10) {
                cumple = true;
            }
        }
        if (cumple) {
            System.out.println("Felicidades ha encontrado el array");
            utils.printArray(numbers);
        }
        if (!cumple) {
            System.out.println("Lo sentimos no ha encontrado un array con esas características");
        }

    }
}
