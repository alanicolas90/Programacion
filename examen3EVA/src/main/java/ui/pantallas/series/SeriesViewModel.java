package ui.pantallas.series;


import domain.modelo.Actor;
import domain.modelo.Episodio;
import domain.modelo.Serie;
import jakarta.inject.Inject;
import servicios.ServicioSeries;

import java.util.List;


public class SeriesViewModel {

    private ServicioSeries servicioSeries;


    @Inject
    public SeriesViewModel(ServicioSeries servicioSeries) {
        this.servicioSeries = servicioSeries;
    }

    public List<Serie> getSeries() {
        return servicioSeries.getSeries();
    }

    public boolean addSerie(Serie serie) {
        return servicioSeries.addSerie(serie);
    }

    public boolean addEpisodio(Episodio episodio, Serie serie) {
        return servicioSeries.addEpisodio(episodio, serie);
    }

    public List<Episodio> getEpisodios(Serie serie) {
        return servicioSeries.getEpisodios(serie);
    }

    public List<Actor> getActores(Serie serie, Episodio episodio) {
        return servicioSeries.getActores(serie, episodio);
    }
}



