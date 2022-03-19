package servicios;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServicioOperacionesTest {

    @Test
    void pruebaSuma() {
        //Given
        int num1 = 1;
        int num2 = 2;

        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.suma(num1, num2);

        //Then
        assertEquals(3, respuesta);
    }

    @Test
    void pruebaSumaConNumeroNegativo() {
        //Given
        int num1 = 1;
        int num2 = -2;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.suma(num1, num2);
        //Then
        assertEquals(-1, respuesta);
    }


    @Test
    void pruebaResta() {
        //Given
        int num1 = 2;
        int num2 = 1;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.resta(num1, num2);
        //Then
        assertEquals(1, respuesta);
    }

    @Test
    void pruebaRestaConResultadoNegativo() {
        //Given
        int num1 = 2;
        int num2 = 5;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.resta(num1, num2);
        //Then
        assertEquals(-1, respuesta);
    }

    @Test
    void pruebaRestaConNumeroNegativo() {
        //Given
        int num1 = 2;
        int num2 = -11;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.resta(num1, num2);
        //Then
        assertEquals(-1, respuesta);
    }

    @Test
    void pruebaMultiplicar(){
        //Given
        int num1 = 2;
        int num2 = 4;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.multiplicar(num1, num2);
        //Then
        assertEquals(8, respuesta);
    }

    @Test
    void pruebaMultiplicarConNumeroNegativa(){
        //Given
        int num1 = 2;
        int num2 = -11;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.multiplicar(num1, num2);
        //Then
        assertEquals(-1, respuesta);
    }

    @Test
    void pruebaDividir(){
        //Given
        int num1 = 2;
        int num2 = 2;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.dividir(num1, num2);
        //Then
        assertEquals(1, respuesta);
    }

    @Test
    void pruebaDividirConDenominadorCero(){
        //Given
        int num1 = 2;
        int num2 = 0;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.dividir(num1, num2);
        //Then
        assertEquals(-1, respuesta);
    }

    @Test
    void pruebaDividirConNumeroNegativo(){
        //Given
        int num1 = 2;
        int num2 = -11;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        int respuesta = sc.dividir(num1, num2);
        //Then
        assertEquals(-1, respuesta);
    }

    @Test
    void pruebaEsMenorQueCero(){
        //Given
        int num= 2;
        //When
        ServicioOperaciones sc = new ServicioOperaciones();
        boolean respuesta = sc.menorQueCero(num);
        //Then
        assertTrue(true, String.valueOf(respuesta));
    }

}
