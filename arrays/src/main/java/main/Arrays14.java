package main;


public class Arrays14 {
    public void media() {
        int[] numbers1 = new int[10];
        int[] numbers2 = new int[10];
        int[] remix = new int[20];
        int contador = 1;


        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = contador + contador;
            contador++;
            System.out.print(numbers1[i]+" ");
        }
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = contador + 3;
            contador++;
            System.out.println(numbers2[i]);
        }

        int positionNumber1 = 0;
        int positionNumber2 = 0;
        int positionRemix = 0;

        while (positionNumber1 < 10 && positionNumber2 < 10) {
            if (numbers1[positionNumber1] < numbers2[positionNumber2]) {
                remix[positionRemix] = numbers1[positionNumber1];
                positionNumber1++;
            } else {
                remix[positionRemix] = numbers2[positionNumber2];
                positionNumber2++;
            }
            positionRemix++;
        }

        if (positionNumber1 == 10) {
            while (positionNumber2 < 10) {
                remix[positionRemix] = numbers2[positionNumber2];
                positionNumber2++;
                positionRemix++;
            }
        } else {
            while (positionNumber1 < 10) {
                remix[positionRemix] = numbers1[positionNumber1];
                positionNumber1++;
                positionRemix++;
            }
        }

        for (int i = 0; i < remix.length; i++) {
            System.out.print(remix[i] + " ");
        }
        System.out.println();
    }
}
