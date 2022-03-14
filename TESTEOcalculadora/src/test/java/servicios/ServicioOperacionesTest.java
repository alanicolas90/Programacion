package servicios;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
