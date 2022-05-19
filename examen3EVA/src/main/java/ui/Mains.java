package ui;

import domain.modelo.Pelicula;
import domain.modelo.Serie;
import domain.modelo.Usuario;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import servicios.ServicioPeliculas;
import servicios.ServicioSeries;
import servicios.ServicioUsuarios;

public class Mains {

    public static void main(String[] args) {

        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();

        ServicioUsuarios servicioUsuarios = container.select(ServicioUsuarios.class).get();
        ServicioPeliculas  servicioPeliculas = container.select(ServicioPeliculas.class).get();
        ServicioSeries servicioSeries = container.select(ServicioSeries.class).get();

        Usuario usuario = new Usuario("pepe", "flipas");
        Pelicula pelicula = new Pelicula("GU", 2017);

        Serie serie = new Serie("wow");

        if(servicioPeliculas.addPelicula(pelicula)) {
            System.out.println("Si");
        }
        else {
            System.out.println("No");
        }
        if(servicioSeries.addSerie(serie)) {
            System.out.println("Si");
        }
        else {
            System.out.println("No");
        }if(servicioUsuarios.addUser(usuario)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        System.out.println(servicioSeries.getSeries());
    }
}
