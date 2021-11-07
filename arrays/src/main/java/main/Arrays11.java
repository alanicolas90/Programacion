package main;

import java.util.Scanner;

public class Arrays11 {
    public void media() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int ordenado = 2;

        for (int i = 0; i < 5; i++) {
            numbers[i] = ordenado;
            ordenado += 2;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("pongame un número que quiera introducir y se colocará automáticamente en el array: ");
        int num = sc.nextInt();

        int numPlace = 0;
        int j = 0;
        // buscaremos el sitio donde debería ir num

        while (numbers[j] <= num && j <= 4) {
            numPlace++;
            j++;
        }

        for (int i = 4; i >= numPlace; i--) {
            numbers[i + 1] = numbers[i];
        }
        numbers[numPlace] = num;

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
