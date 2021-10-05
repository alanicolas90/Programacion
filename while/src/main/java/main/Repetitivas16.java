package main;

import java.util.Scanner;

public class Repetitivas16 {
    public void media(Scanner sc) {
        int sueldoTrabajadores = 0;

        System.out.print("Dime el sueldo de los trabajadores por hora: ");
        int sueldoHora = sc.nextInt();

        System.out.print("Cuantos trabajadores tienes? ");
        int cantidadTrabajadores = sc.nextInt();

        for (int trabajadores=1; trabajadores != cantidadTrabajadores+1; trabajadores++) {
            System.out.println("Ponga las horas trabajadas del empleado numero " + trabajadores);
            int horasTrabajador = sc.nextInt();
            sueldoTrabajadores = sueldoTrabajadores + (sueldoHora * horasTrabajador);
            System.out.println("El sueldo del empleado "+trabajadores+" es de: "+(sueldoHora * horasTrabajador)+"€");
        }
        System.out.println("La empresa tiene que pagar por " + cantidadTrabajadores + " empleados: " + sueldoTrabajadores + " €");

    }
}
