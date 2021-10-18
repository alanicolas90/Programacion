package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int numeroEjercicio=1;

        do{
            System.out.println("Pulse 1 para codificar en Cesar");
            System.out.println("Pulse 2 para descifrar en Cesar");
            System.out.println("Pulse 3 para codificar en Vigenere");
            System.out.println("Pulse 4 para descifrar en Vigenere");
            numeroEjercicio=sc.nextInt();

            switch (numeroEjercicio){
                case 1:
                    Cesar_codificar codificarCesar= new Cesar_codificar();
                    codificarCesar.media(sc);
                    break;

                case 2:
                    Cesar_descifrar descifrarCesar= new Cesar_descifrar();
                    descifrarCesar.media(sc);
                    break;
                case 3:
                    Vigenere_codificar codificarVigenere= new Vigenere_codificar();
                    codificarVigenere.media(sc);
                    break;
                case 4:
                    Vigenere_descifrar descifrarVigenere= new Vigenere_descifrar();
                    descifrarVigenere.media(sc);
                    break;
            }
        }while(numeroEjercicio!=0);
    }
}
