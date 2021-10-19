package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int numeroEjercicio;

        do{
            System.out.println("PULSE 0 PARA SALIR");
            System.out.println("Pulse 1 para cifrar en Cesar");
            System.out.println("Pulse 2 para descifrar en Cesar");
            System.out.println("Pulse 3 para cifrar en Vigenere");
            System.out.println("Pulse 4 para descifrar en Vigenere");
            numeroEjercicio=sc.nextInt();

            switch (numeroEjercicio){
                case 1:
                    Cesar_codificar codificarCesar= new Cesar_codificar();
                    sc.nextLine();
                    codificarCesar.media(sc);
                    break;

                case 2:
                    Cesar_descifrar descifrarCesar= new Cesar_descifrar();
                    sc.nextLine();
                    descifrarCesar.media(sc);
                    break;
                case 3:
                    Vigenere_codificar codificarVigenere= new Vigenere_codificar();
                    sc.nextLine();
                    codificarVigenere.media(sc);
                    break;
                case 4:
                    Vigenere_descifrar descifrarVigenere= new Vigenere_descifrar();
                    sc.nextLine();
                    descifrarVigenere.media(sc);
                    break;
            }
        }while(numeroEjercicio!=0);
    }
}
