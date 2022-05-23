package ui.client;

import constantes.Constantes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import servicios.ServicioClients;
import servicios.ServicioCompras;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemOut;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class UiClientSettingsTest {

    //class under test
    UiClientSettings uiClientSettings;


    @Mock
    ServicioClients servicioClients;
     @Mock
    ServicioCompras servicioCompras;
    Scanner sc;

    @SystemStub
    private SystemOut systemOut;


    @Test
    void settingsCliente() throws Exception{
        //given
        Scanner sc = new Scanner(new LinesAltStream("0"));

        uiClientSettings = new UiClientSettings(servicioClients, servicioCompras, sc);
//when
        uiClientSettings.settingsCliente("0");

        //then
        verify(uiClientSettings).settingsCliente("01");
        assertThat(systemOut.getText()).contains(Constantes.ERROR_POR_FAVOR_TRY_AGAIN);
    }
}