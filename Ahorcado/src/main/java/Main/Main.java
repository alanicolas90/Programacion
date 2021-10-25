package Main;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        // definir valores iniciales

        // el numero de oportunidades

        int intentosRestantes = 7;
        System.out.println("Tienes " + intentosRestantes + " intentos restantes.");


        // la palabra a encontrar.
        Faker crearPalabra = new Faker();
        String palabra = crearPalabra.animal().name();//palabra que queremos encontrar(serán animales)

        // la palabra ocultada.
        for (int letraPalabra = 0; letraPalabra < palabra.length(); letraPalabra++) {
            palabra.charAt(letraPalabra);
        }
        //bucle hasta oportunidades o que acierte


        // DIFICIL mostrar palabra ocultada *** ****   *A* *****

        // pedirle letra, comprobar que la letra sea nueva
        // o pedir frase  jugarsela

        // ver si esta  o no

        // si no esta saco ahorcado

        if(intentosRestantes<=7 && intentosRestantes>0){
            switch (intentosRestantes){
                case 7:
                    System.out.println(" ___________\n |         |\n |\n |\n |\n |\n/ \\");
                    break;
                case 6:
                    System.out.println(" ___________\n |         |\n |        ( )\n |\n |\n |\n/ \\");
                    break;
                case 5:
                    System.out.println(" ___________\n |         |\n |        ( )\n |         |\n |\n |\n/ \\");
                    break;
                case 4:
                    System.out.println(" ___________\n |         |\n |        ( )\n |        /|\n |\n |\n/ \\");
                    break;
                case 3:
                   System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |\n |\n/ \\");
                    break;
                case 2:
                    System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |        /\n |\n/ \\");
                    break;
                case 1:
                    System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |        / \\ \n |\n/ \\");
                    break;

            }



        }

        // si esta saco palabra con caracteres descubiertos
    }
}
