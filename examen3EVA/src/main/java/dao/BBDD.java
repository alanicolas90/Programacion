package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuration;
import domain.modelo.Pelicula;
import domain.modelo.Serie;
import domain.modelo.Usuario;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class BBDD {

    private final Gson gson;

    private final Configuration configuration;


    @Inject
    public BBDD(Gson gson, Configuration configuration) {
        this.gson = gson;
        this.configuration = configuration;
    }


//          USUARIOS          USUARIOS          USUARIOS          USUARIOS          USUARIOS

    public Map<String, Usuario> loadUsuarios() {
        Type userListType = new TypeToken<LinkedHashMap<String, Usuario>>() {
        }.getType();
        LinkedHashMap<String, Usuario> usuarios = null;
        try {
            usuarios = gson.fromJson(
                    new FileReader(Configuration.getInstance().getUsuariosSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return usuarios;
    }

    public boolean saveUsuarios(Map<String, Usuario> usuarios) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getUsuariosSource())) {
            gson.toJson(usuarios, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

//          PELICULAS          PELICULAS          PELICULAS          PELICULAS          PELICULAS

    public List<Pelicula> loadPeliculas() {
        Type userListType = new TypeToken<ArrayList<Pelicula>>() {
        }.getType();
        List<Pelicula> peliculas = null;
        try {
            peliculas = gson.fromJson(
                    new FileReader(Configuration.getInstance().getPeliculasSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return peliculas;
    }

    public boolean savePeliculas(List<Pelicula> peliculas) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getPeliculasSource())) {
            gson.toJson(peliculas, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    //             SERIES                   SERIES                   SERIES                   SERIES

    public List<Serie> loadSeries() {
        Type userListType = new TypeToken<ArrayList<Serie>>() {
        }.getType();
        List<Serie> series = null;
        try {
            series = gson.fromJson(
                    new FileReader(Configuration.getInstance().getSeriesSource()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return series;
    }

    public boolean saveSeries(List<Serie> series) {
        try (FileWriter w = new FileWriter(Configuration.getInstance().getSeriesSource())) {
            gson.toJson(series, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

}
