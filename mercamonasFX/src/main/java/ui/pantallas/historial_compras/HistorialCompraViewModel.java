package ui.pantallas.historial_compras;


import jakarta.inject.Inject;
import servicios.impl.ServicioProductosImpl;

public class HistorialCompraViewModel {

    private ServicioProductosImpl servicioProductos;

    @Inject
    public HistorialCompraViewModel(ServicioProductosImpl servicioProductos) {
        this.servicioProductos = servicioProductos;
    }

//    public ObservableList getProductos() {
//        return (ObservableList) servicioProductos.showAllProducts();
//    }



}
