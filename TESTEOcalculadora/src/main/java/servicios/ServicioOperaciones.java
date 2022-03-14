package servicios;

public class ServicioOperaciones {

    public int suma(int num1, int num2) {
        if (num1 >= 0 || num2 >= 0)
            return num1 + num2;
        else
            return -1;
    }

    public int resta(int num1, int num2) {
        if (num1 < 0 || num2 < 0 || (num1 - num2) < 0) {
            return -1;
        } else
            return num1 - num2;
    }

    public int multiplicar(int num1, int num2) {
        if (num1 >= 0 || num2 >= 0)
            return num1 * num2;
        else
            return -1;
    }

    public int dividir(int num1, int num2) {
        if (num1 >= 0 || num2 > 0)
            return num1 / num2;
        else
            return -1;

    }

    public boolean menorQueCero(int num) {
        return (num < 0);
    }
}
