package main;

import java.util.Scanner;

public class Repetitivas17 {
    public void media(Scanner sc, int i) {
        int sueldoTrabajadores = 0;
        int sueldoPagarEmpresa = 0;

        System.out.print("Dime el sueldo de los trabajadores por hora: ");
        int sueldoHora = sc.nextInt();

        System.out.print("Cuantos trabajadores tienes? ");
        int cantidadTrabajadores = sc.nextInt();

        for (int trabajadores = 1; trabajadores != cantidadTrabajadores + 1; trabajadores++) {
            System.out.println("Ponga los dias que ha trabajado (1-7) el empleado " + trabajadores);
            int diasTrabajados = sc.nextInt();

            for (int dias = 1; dias != diasTrabajados + 1; dias++) {
                if (diasTrabajados > 0 && diasTrabajados <= 7) {
                    System.out.println("Ponga las horas trabajadas del empleado numero " + trabajadores + " el día " + dias);
                    int horasTrabajador = sc.nextInt();
                    sueldoTrabajadores = sueldoTrabajadores + (sueldoHora * horasTrabajador);
                } else {
                    System.out.println("ERROR. Ponga un valor valor entre 1-7");
                    return;
                }
            }
            sueldoPagarEmpresa = sueldoTrabajadores + sueldoTrabajadores;
            System.out.println("El sueldo del empleado " + trabajadores + " es de: " + sueldoTrabajadores + "€");
            sueldoTrabajadores = 0;

        }
        System.out.println("La empresa tiene que pagar por " + cantidadTrabajadores + " empleados: " + sueldoPagarEmpresa + " €");


    }
}
