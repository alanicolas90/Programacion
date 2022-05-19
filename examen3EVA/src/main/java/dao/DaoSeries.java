package dao;

import domain.modelo.Actor;
import domain.modelo.Episodio;
import domain.modelo.Serie;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class DaoSeries {

    private final BBDD db;

    @Inject
    public DaoSeries(BBDD db) {
        this.db = db;
    }

    public boolean addSerie(Serie serie) {
        boolean ok;
        List<Serie> series = db.loadSeries();
        if (series == null) {
            series = new ArrayList<>();
        }

        series.add(serie);

        ok = db.saveSeries(series);

        return ok;
    }

    public boolean serieExiste(Serie serie) {
        boolean existe = false;
        List<Serie> series = db.loadSeries();
        if (series != null) {
            existe = series.stream().anyMatch(serie1 -> serie1.getNameSerie().equals(serie.getNameSerie()));
        }
        return existe;
    }

    public List<Serie> getSeries() {
        return db.loadSeries();
    }

    public boolean addEpisodio(Episodio episodio, Serie serie) {
        List<Serie> series = db.loadSeries();
        int index = series.indexOf(serie);
        series.get(index).getEpisodios().add(episodio);

        return db.saveSeries(series);
    }

    public List<Episodio> getEpisodios(Serie serie) {
        List<Serie> series = db.loadSeries();
        return series.get(series.indexOf(serie)).getEpisodios();
    }

    public List<Actor> getActores(Serie serie, Episodio episodio) {
        List<Serie> series = db.loadSeries();
        int indexSerie = series.indexOf(serie);
        return series.get(indexSerie).getEpisodios().stream().filter(episodio1 -> episodio1.getId().equals(episodio.getId())).findFirst().get().getActores();
    }

    public boolean updateValoracion(Serie serie, String valo) {
        List<Serie> series = db.loadSeries();
        series.get(series.indexOf(serie)).setValoracion(Integer.valueOf(valo));
        return db.saveSeries(series);
    }

    public boolean updatebool(Serie serie, String bool) {
        List<Serie> series = db.loadSeries();
        series.get(series.indexOf(serie)).setVisto(Boolean.parseBoolean(bool));
        return db.saveSeries(series);
    }

    public void updateListaSeriesVistas(Serie serie) {

    }
}
