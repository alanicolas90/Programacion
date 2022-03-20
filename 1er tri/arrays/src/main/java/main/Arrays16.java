package main;

import java.util.Random;
import java.util.Scanner;

public class Arrays16 {
    public void media() {
        Scanner sc = new Scanner(System.in);
        int[] trimestre1 = new int[5];
        int[] trimestre2 = new int[5];
        int[] trimestre3 = new int[5];
        double mediaTrimestre1 = 0;
        double mediaTrimestre2 = 0;
        double mediaTrimestre3 = 0;
        double mediaAlumno=0;
        int numeroAlumno;
        Random r = getR();

        for (int i = 0; i < trimestre1.length; i++) {
            trimestre1[i] = r.nextInt(10);
            System.out.print(trimestre1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < trimestre2.length; i++) {
            trimestre2[i] = r.nextInt(10);
            System.out.print(trimestre2[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < trimestre3.length; i++) {
            trimestre3[i] = r.nextInt(10);
            System.out.print(trimestre3[i] + " ");
        }
        System.out.println();

        //La media

        for (int i = 0; i < trimestre1.length; i++) {
            mediaTrimestre1 = trimestre1[i] + mediaTrimestre1;
            mediaTrimestre2 = trimestre2[i] + mediaTrimestre2;
            mediaTrimestre3 = trimestre3[i] + mediaTrimestre3;
        }
        System.out.println("La media del primer trimestre: " + (mediaTrimestre1 / 5));
        System.out.println("La media del segundo trimestre: " + (mediaTrimestre2 / 5));
        System.out.println("La media del tercer trimestre: " + (mediaTrimestre3 / 5));


        System.out.println("Dime el alumno (1-5)");
        numeroAlumno = sc.nextInt();
        do{
            if(numeroAlumno>5 || numeroAlumno<0) {
                System.out.println("VALOR INCORRECTO. escriba un número entre 1 y el 5.");
                numeroAlumno=sc.nextInt();
            }
        }while(numeroAlumno>5 || numeroAlumno<0);

        numeroAlumno = numeroAlumno - 1;

        for (int i = numeroAlumno; i ==numeroAlumno ; i++) {
            mediaAlumno=((double) (trimestre1[i]+trimestre2[i]+trimestre3[i])/3);
        }

        System.out.println("La media del alumno solicitado es:"+ mediaAlumno);
    }

    private Random getR() {
        return new Random();
    }
}
