package servicios;

public class ServiciosCartas {
    public void crearBarajaEj17(int[]cartas){
        for (int i = 0; i < 20; i++) {
            cartas[i] = (i + 1)%10;
        }
    }
    public void crearBarajaSpain(int[] cartas) {
        for (int i = 0; i < 40; i++) {
            cartas[i] = (i + 1) % 10;
        }
    }
    public void crearBarajaEnglish(int[] cartas) {
        for (int i = 0; i < 52; i++) {
            cartas[i] = (i + 1) % 12;
        }
    }
}
