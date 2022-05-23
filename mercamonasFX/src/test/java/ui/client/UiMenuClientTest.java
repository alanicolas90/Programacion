package ui.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import servicios.ServicioClients;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemOut;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class UiMenuClientTest {

    UiMenuClient uiMenuClient;

    @Mock
    ServicioClients servicioClients;
    @Mock
    UiClientSettings uiClientSettings;
    @Mock
    UiMenuClientBuy uiMenuClientBuy;

    @SystemStub
    private SystemOut systemOut;

    @Test
    void menuSwitchClient() {
        //given
        Scanner sc = new Scanner(new LinesAltStream("01","0","0"));

        uiMenuClient = new UiMenuClient(servicioClients,uiClientSettings,uiMenuClientBuy,sc);
        when(servicioClients.existeCliente("01")).thenReturn(true);

        //when
        uiMenuClient.menuSwitchClient();

        //then
        verify(uiMenuClient).menuSwitchClient();

    }
}