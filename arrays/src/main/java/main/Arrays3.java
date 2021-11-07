package main;

import java.util.Random;

public class Arrays3 {
    public void media(){
        int counterZeros=0;
        double counterPositives=0;
        double counterNegatives=0;
        double sumPositives=0;
        double sumNegatives=0;
        boolean hayNegativos=false;
        boolean hayPositivos=false;

        int[] numbers = new int[5];
        Random r = getR();
        for (int i = 0; i < numbers.length; i++) {
            int randomNumber = r.nextInt(10);
            numbers[i]= randomNumber;
            System.out.println(randomNumber);
        }
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>0){
                hayPositivos=true;
                counterPositives++;
                sumPositives=sumPositives+numbers[i];
            }else if(numbers[i]<0){
                hayNegativos=true;
                counterNegatives++;
                sumNegatives=sumNegatives+numbers[i];
            }else{
                counterZeros++;
            }
        }
        if(hayPositivos){
            double  averagePositives=sumPositives/counterPositives;
            System.out.println("The average from positives are: "+averagePositives);
        }
        if(hayNegativos){
            double averageNegatives=sumNegatives/counterNegatives;
            System.out.println("The average from negative numbers is: "+averageNegatives);
        }else {
            System.out.println("No hay valores negativos");
        }
        System.out.println("The quantity of 0 is:" +counterZeros);
    }

    private Random getR() {
        return new Random();
    }
}
