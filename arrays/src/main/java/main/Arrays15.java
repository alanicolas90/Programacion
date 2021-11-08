package main;

import java.util.Scanner;

public class Arrays15 {
    public void media() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        boolean isNumber = false;
        int positionFound = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("Pon el número que quieres encontrar: ");
        int numberSearch = sc.nextInt();

        for (int i = 0; i < numbers.length && !isNumber; i++) {
            if (numbers[i] == numberSearch) {
                positionFound = i;
                isNumber = true;
            }
        }
        if (isNumber) {
            System.out.println("The number was found in the position: " + positionFound);
        } else {
            System.out.println("The number you typed was not found");
        }
    }
}
