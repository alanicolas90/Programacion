package ui.pantallas.monedero;

import domain.modelo.cliente.Monedero;
import jakarta.inject.Inject;
import servicios.impl.ServicioClientsImpl;
import servicios.impl.ServicioComprasImpl;

public class MonederoViewModel {

    private ServicioComprasImpl servicioCompras;

    @Inject
    public MonederoViewModel(ServicioComprasImpl servicioCompras) {
        this.servicioCompras = servicioCompras;
    }

//    public Monedero getMonedero() {
//        return servicioCompras.show;
//    }
}
