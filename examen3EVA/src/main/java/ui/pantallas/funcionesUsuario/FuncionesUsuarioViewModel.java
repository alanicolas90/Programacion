package ui.pantallas.funcionesUsuario;


import domain.modelo.Serie;
import jakarta.inject.Inject;
import javafx.collections.ObservableList;
import servicios.ServicioSeries;

import java.util.List;

public class FuncionesUsuarioViewModel {

private ServicioSeries servicioSeries;

    @Inject
    public FuncionesUsuarioViewModel(ServicioSeries servicioSeries) {
        this.servicioSeries = servicioSeries;

    }

    public List<Serie> getSeries() {
        return servicioSeries.getSeries();
    }

    public boolean updateValoracion(Serie serie, String valo) {
        return servicioSeries.updateValoracion(serie, valo);
    }

    public boolean updatebool(Serie serie, String bool) {
        return servicioSeries.updatebool(serie, bool);
    }

    public void updateListaSeriesVistas(Serie serie) {
        servicioSeries.updateListaSeriesVistas(serie);
    }

//    public ObservableList getProductos() {
//        return (ObservableList) servicioProductos.showAllProducts();
//    }



}
