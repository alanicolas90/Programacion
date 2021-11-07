package main;


import java.util.Random;
import java.util.Scanner;

public class Arrays8 {
    public void media() {
        Scanner sc = new Scanner(System.in);
        int numbers[] = new int[10];

        Random r = new Random();

        for (int i = 0; i < 8; i++) {
            numbers[i] = r.nextInt(10);
        }
        System.out.print("dime un numero: ");
        int number= sc.nextInt();
        System.out.println("dime una posición entre 1 y 10");
        int position=sc.nextInt();

        position=position-1;
        for (int i = (numbers.length-2); i >= position; i--) {
            numbers[i+1]=numbers[i];
        }
        numbers[position]=number;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]+" ");
        }
    }
}
