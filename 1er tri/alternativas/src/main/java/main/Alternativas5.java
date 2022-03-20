package main;

import java.util.Scanner;

public class Alternativas5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Digame su USUARIO: ");
        String usuario=sc.nextLine();


        if (usuario.equals("pepe")){
            System.out.print("Digame su CONTRASEÑA: ");
            String password= sc.nextLine();

            if (password.equals(password)){
                System.out.println("Has entrado al sistema.");
            }
            else{
                System.out.println("CONTRASEÑA INCORRECTA.");
            }
        }
        else{
            System.out.println("USUARIO incorrecto.");
        }


    }
}
