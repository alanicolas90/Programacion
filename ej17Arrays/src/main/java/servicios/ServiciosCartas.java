package servicios;

import java.util.Random;

public class ServiciosCartas {
    public void crearBarajaEj17(int[] cartas) {
        for (int i = 0; i < 20; i++) {
            cartas[i] = (i % 10) + 1;
        }
    }

    public void crearBarajaSpain(int[] cartas) {
        for (int i = 0; i < 40; i++) {
            cartas[i] = (i % 10) + 1;
        }
    }

    public void crearBarajaEnglish(int[] cartas) {
        for (int i = 0; i < 52; i++) {
            cartas[i] = (i % 12) + 1;
        }
    }

    public void shuffleBaraja(int[] cartas) {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomPosition1 = r.nextInt(cartas.length);
            int randomPosition2 = r.nextInt(cartas.length);
            int saveCard = cartas[randomPosition1];

            cartas[randomPosition1] = cartas[randomPosition2];
            cartas[randomPosition2] = saveCard;

        }
    }
}
