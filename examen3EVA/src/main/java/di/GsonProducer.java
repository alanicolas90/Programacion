package di;

import com.google.gson.*;
import domain.modelo.Pelicula;
import domain.modelo.Serie;
import domain.modelo.Usuario;
import gsonutils.RuntimeTypeAdapterFactory;
import jakarta.enterprise.inject.Produces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonProducer {

    @Produces
    public Gson getGson() {
        RuntimeTypeAdapterFactory<Serie> adapterSerie =
                RuntimeTypeAdapterFactory
                        .of(Serie.class, "type", true)
                        .registerSubtype(Serie.class, "Serie");

        RuntimeTypeAdapterFactory<Pelicula> adapterPelicula =
                RuntimeTypeAdapterFactory
                        .of(Pelicula.class, "type", true)
                        .registerSubtype(Pelicula.class, "Pelicula");

        RuntimeTypeAdapterFactory<Usuario> adapterUsuario=
                RuntimeTypeAdapterFactory
                        .of(Usuario.class, "type", true)
                        .registerSubtype(Usuario.class, "Usuario");


        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(localDateTime.toString()))
                .registerTypeAdapter(LocalDate.class,
                        (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
                                LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDate.class,
                        (JsonSerializer<LocalDate>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(localDateTime.toString()))
                .registerTypeAdapterFactory(adapterSerie)
                .registerTypeAdapterFactory(adapterPelicula)
                .registerTypeAdapterFactory(adapterUsuario)
                .create();

    }

}
