package servicios;

import dao.DaoSeries;
import domain.modelo.Actor;
import domain.modelo.Episodio;
import domain.modelo.Serie;
import jakarta.inject.Inject;

import java.util.List;

public class ServicioSeries {

    private DaoSeries daoSeries;

    @Inject
    public ServicioSeries(DaoSeries daoSeries) {
        this.daoSeries = daoSeries;
    }

    public boolean addSerie(Serie serie){
        if(!daoSeries.serieExiste(serie)) {
            return daoSeries.addSerie(serie);
        }else{
            return false;
        }
    }

    public List<Serie> getSeries(){
        return daoSeries.getSeries();
    }

    public boolean addEpisodio(Episodio episodio, Serie serie) {
        if(daoSeries.serieExiste(serie)) {
            return daoSeries.addEpisodio(episodio, serie);
        }else{
            return false;
        }
    }

    public List<Episodio> getEpisodios(Serie serie) {
        return daoSeries.getEpisodios(serie);

    }

    public List<Actor> getActores(Serie serie, Episodio episodio) {
        return daoSeries.getActores(serie, episodio);
    }

    public boolean updateValoracion(Serie serie, String valo) {
        return daoSeries.updateValoracion(serie, valo);
    }

    public boolean updatebool(Serie serie, String bool) {
        return daoSeries.updatebool(serie, bool);
    }

    public void updateListaSeriesVistas(Serie serie) {
        daoSeries.updateListaSeriesVistas(serie);
    }
}
