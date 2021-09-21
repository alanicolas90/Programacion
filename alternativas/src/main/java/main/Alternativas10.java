package main;

import java.util.Scanner;

public class Alternativas10 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Dame la coordenada x1: ");
        int coordenadaX1=sc.nextInt();
        System.out.print("Dame la coordenada y1: ");
        int coordenadaY1=sc.nextInt();
        System.out.print("Dame el radio de la circunferencia r1: ");
        int radioR1=sc.nextInt();

        System.out.print("Dame la coordenada x2: ");
        int coordenadaX2=sc.nextInt();
        System.out.print("Dame la coordenada y2: ");
        int coordenadaY2=sc.nextInt();
        System.out.print("Dame el valor r2: ");
        int radioR2=sc.nextInt();

        int restaCoordenadas1=(coordenadaX2-coordenadaX1);
        int restaCoordenadas2=(coordenadaY2-coordenadaY1);
        int sumaRadios=radioR1+radioR2;
        int restaRadios=Math.abs(radioR1-radioR2);


        double distanciaEntreOrigenes= Math.sqrt((Math.pow(restaCoordenadas1,2)) + (Math.pow(restaCoordenadas2,2)));

        if(distanciaEntreOrigenes==0){
            System.out.println("Son circunferencias CONCENTRICAS");
        }
        else if(distanciaEntreOrigenes==restaRadios){
            System.out.println("Son circunferencias TANGENTES INTERIORES");
        }
        else if(distanciaEntreOrigenes==sumaRadios){
            System.out.println("Son circunferencias TANGENTES EXTERIORES");
        }
        else if(distanciaEntreOrigenes>sumaRadios){
            System.out.println("Son circunferencias EXTERIORES.");
        }
        else if(distanciaEntreOrigenes<sumaRadios){
            System.out.println("Son circunferencias SECANTES.");
        }
        else if(distanciaEntreOrigenes<restaRadios){
            System.out.println("Son circunferencias INTERIORES");
        }

    }
}
