package ui;

import common.Common;
import servicios.ServicioAlumno;
import servicios.ServicioListas;
import servicios.ServicioProfesores;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Common common = new Common();
        Scanner sc = new Scanner(System.in);
        System.out.println("BIENVENIDO");
        int option;

        do {
            System.out.println("Que desea hacer");
            System.out.println("1) Matricular a un alumno a una asignatura\n" +
                    "2) Poner una nota a un alumno en una asignatura\n" +
                    "3) Hacer la cotización mensual de los empleados\n" +
                    "4) Ver listado de profesores ordenados por el número de asignaturas que tienen\n" +
                    "5) Entras como un alumno y te muestra la media de todas las asignaturas.\n\n" +
                    "0) Exit");
            option = common.giveInt();

            switch (option) {
                case 1:
                    matricularAlumnoAsignatura(sc);
                    break;
                case 2:
                    meterNotaAlumno(common, sc);
                    break;
                case 3:
                    cotizar();
                    break;
                case 4:
                    showListaProfeOrdenado();
                    break;
                case 5:
                    System.out.println("no puedo hacerlo porque no tengo las notas hechas.");
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("No hay tal opción");
                    break;
            }
        } while (option != 0);
    }

    private static void cotizar() {
        ServicioProfesores servicioProfesores = new ServicioProfesores();
        servicioProfesores.cotizarALosQueHayQueCotizar();
        System.out.println("Ya se ha hecho la cotización");
    }

    private static void matricularAlumnoAsignatura(Scanner sc) {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        System.out.println("Que alumno quieres matricular (dime el dni)");
        String dniAlumno= sc.nextLine();

        System.out.println("Dime a que asignatura quieres meterle (nombre)");
        String asignatura= sc.nextLine();

        if(servicioAlumno.matricularAlumnoEnAsignatura(dniAlumno, asignatura)){
            System.out.println("Logrado con éxito");
        }else{
            System.out.println("Error");
        }
    }

    private static void showListaProfeOrdenado() {
        ServicioListas servicioListas = new ServicioListas();
        System.out.println(servicioListas.listaProfesoresOrdenado());
    }

    private static void meterNotaAlumno(Common common, Scanner sc) {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        System.out.println("Dime el dni del alumno");
        String dniAlumno= sc.nextLine();

        System.out.println("Dime que asignatura quieres ponerle la nota");
        String asignatura= sc.nextLine();

        System.out.println("Dime que nota le quieres poner");
        int notaAlumno= common.giveInt();

        if(servicioAlumno.ponerNotaAlumno(dniAlumno,asignatura,notaAlumno)){
            System.out.println("Felicidades se ha logrado");
        }else{
            System.out.println("ERROR");
        }
    }
}
